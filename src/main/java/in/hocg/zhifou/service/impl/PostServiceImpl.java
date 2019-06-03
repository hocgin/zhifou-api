package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.sun.xml.internal.rngom.util.Uri;
import in.hocg.zhifou.domain.*;
import in.hocg.zhifou.manager.ConfigManager;
import in.hocg.zhifou.manager.RedisManager;
import in.hocg.zhifou.mapper.PostMapper;
import in.hocg.zhifou.mapping.PostMapping;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.ro.SearchPostRo;
import in.hocg.zhifou.pojo.ro.TimelineQueryPostRo;
import in.hocg.zhifou.pojo.vo.PostDetailVo;
import in.hocg.zhifou.pojo.vo.PostSummaryVo;
import in.hocg.zhifou.pojo.vo.TimelinePostVo;
import in.hocg.zhifou.pojo.vo.UserSummaryVo;
import in.hocg.zhifou.service.*;
import in.hocg.zhifou.support.base.request.PageQuery;
import in.hocg.zhifou.support.mybatis.MybatisPlusKit;
import in.hocg.zhifou.util.ApiException;
import in.hocg.zhifou.util.Vid;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor(onConstructor_ = {@Lazy})
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
        implements PostService {
    private final UserService userService;
    private final GalleryService galleryService;
    private final WebsiteService websiteService;
    private final TagService tagService;
    private final PostTagRefService postTagRefService;
    private final FavoriteService favoriteService;
    private final CommentService commentService;
    
    private final RedisManager redisService;
    private final ConfigManager configManager;
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void published(PublishedPostRo param, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        
        // 保存文章
        Post post = PostMapping.INSTANCE.fromPublishedPostRo(param);
        post.setCreator(user.getId());
        baseMapper.insert(post);
        
        // 批量保存图片
        List<String> galleries = param.getGalleries();
        if (!galleries.isEmpty()) {
            galleryService.saveBatch(galleries.stream()
                    .map((image) -> {
                        Gallery gallery = new Gallery();
                        gallery.setImage(image);
                        gallery.setPostId(post.getId());
                        return gallery;
                    }).collect(Collectors.toSet()));
        }
        
        // 批量保存站点
        List<String> websites = param.getWebsite();
        if (!websites.isEmpty()) {
            websiteService.saveBatch(websites.stream()
                    .map((url) -> {
                        Website website = new Website();
                        website.setWebsite(url);
                        website.setPostId(post.getId());
                        return website;
                    }).collect(Collectors.toSet()));
        }
        
        // 批量保存标签
        postTagRefService.saveBatch(param.getTags().stream()
                .map((id) -> {
                    if (Objects.isNull(tagService.getById(id))) {
                        throw ApiException.newInstance("选择的标签不存在");
                    }
                    PostTagRef postTagRef = new PostTagRef();
                    postTagRef.setTagId(id);
                    postTagRef.setPostId(post.getId());
                    return postTagRef;
                }).collect(Collectors.toSet()));
        
        // 发表评论
//        if (Strings.isNotBlank(param.getFirstComment())) {
//            commentService.comment(principal, );
//        }
    
    }
    
    @Override
    public Page<PostSummaryVo> paging(Principal principal, PageQuery<Void> pageQuery) {
        User user;
        Long userId = null;
        if (Objects.nonNull(principal)) {
            String username = principal.getName();
            user = userService.findByUsername(username);
            userId = user.getId();
        }
        Long finalUserId = userId;
        
        Page page = pageQuery.page();
        QueryWrapper<Post> wrapper = pageQuery.wrapper();
        
        IPage<Post> result = baseMapper.selectPage(page, wrapper);
        
        List<PostSummaryVo> list = result.getRecords().stream()
                .map((post) -> fillPostSummary(finalUserId, post))
                .collect(Collectors.toList());
        
        Page<PostSummaryVo> rtn = MybatisPlusKit.newPage(result);
        rtn.setRecords(list);
        return rtn;
    }
    
    @Override
    public List<PostSummaryVo> search(Principal principal, SearchPostRo query) {
        String keyword = query.getKeyword();
        return baseMapper.search(keyword);
    }
    
    @Override
    public PostDetailVo getPostDetail(Principal principal, String v) {
        Long id = Vid.decode(v);
        Post post = baseMapper.selectById(id);
        if (Objects.isNull(post)) {
            throw ApiException.newInstance("文章不存在");
        }
        
        Long uid = null;
        if (Objects.nonNull(principal)) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            uid = user.getId();
        }
        
        return fillPostDetail(uid, post);
    }
    
    @Override
    public PostDetailVo fillPostDetail(Long userId, Post post) {
        if (Objects.isNull(post)) {
            return null;
        }
        
        PostDetailVo result = PostMapping.INSTANCE.toPostDetailVo(post);
        
        // 作者
        User author = userService.getById(post.getCreator());
        if (Objects.nonNull(author)) {
            result.setAuthor(new UserSummaryVo(author));
        }
        
        // 浏览量
        result.setPageviews(redisService.getPageviewsCount(String.valueOf(post.getId())));
        
        String vid = Vid.encode(post.getId());
        result.setV(vid);
        
        // 设置相对路径
        result.setUri(String.format("/post?v=%s", vid));
    
        // 图片地址
        post.setThumb(Uri.resolve(configManager.getImageServer(), post.getThumb()));
        
        // 标签
        List<Tag> tags = tagService.findByPostId(post.getId());
        result.setTags(tags);
        
        // 图片
        List<Gallery> gallery = galleryService.findByPostId(post.getId());
        result.setGalleries(gallery.stream()
                .map((item)-> Uri.resolve(configManager.getImageServer(), item.getImage()))
                .collect(Collectors.toSet()));
        
        // 关联网址
        List<Website> websites = websiteService.findByPostId(post.getId());
        result.setWebsites(websites);
        
        // 关联用户详情
        if (Objects.nonNull(userId)) {
            boolean alreadyFavorite = favoriteService.alreadyFavorite(userId, post.getId());
            result.setIsFavorites(alreadyFavorite);
        }
        
        return result;
    }
    
    @Override
    public PostSummaryVo fillPostSummary(Long userId, Post post) {
        if (Objects.isNull(post)) {
            return null;
        }
        PostSummaryVo result = PostMapping.INSTANCE.toPostSummaryVo(post);
        
        // 作者
        User author = userService.getById(post.getCreator());
        if (Objects.nonNull(author)) {
            result.setAuthor(new UserSummaryVo(author));
        }
    
        // 图片地址
        result.setThumb(Uri.resolve(configManager.getImageServer(), post.getThumb()));
        
        // 浏览量
        result.setPageviews(redisService.getPageviewsCount(String.valueOf(post.getId())));
        
        // 业务ID
        String vid = Vid.encode(post.getId());
        result.setV(vid);
        
        // 文章路径
        result.setUri(String.format("/post?v=%s", vid));
        
        // 标签
        List<Tag> tags = tagService.findByPostId(post.getId());
        result.setTags(tags);
        
        // 关联用户信息
        if (Objects.nonNull(userId)) {
            boolean alreadyFavorite = favoriteService.alreadyFavorite(userId, post.getId());
            result.setIsFavorites(alreadyFavorite);
        }
        return result;
    }
    
    @Override
    public Map<Integer, List<PostSummaryVo>> findAllByTimeline(Principal principal, TimelineQueryPostRo query) {
        User user;
        Long userId = null;
        if (Objects.nonNull(principal)) {
            String username = principal.getName();
            user = userService.findByUsername(username);
            userId = user.getId();
        }
        Long finalUserId = userId;
        
        Map<Integer, List<PostSummaryVo>> result = Maps.newHashMap();
        List<PostSummaryVo> item;
        for (Integer i = 0; i <= query.getCursor(); i++) {
            item = baseMapper.findAllByCreatedDay(LocalDate.now().minusDays(i))
                    .stream()
                    .map((post) -> fillPostSummary(finalUserId, post))
                    .collect(Collectors.toList());
            result.put(i, item);
        }
        return result;
    }
    
    @Override
    public TimelinePostVo findPostsByTimeline(Principal principal, TimelineQueryPostRo query) {
        User user;
        Long userId = null;
        if (Objects.nonNull(principal)) {
            String username = principal.getName();
            user = userService.findByUsername(username);
            userId = user.getId();
        }
        
        Integer cursor = query.getCursor();
        LocalDate localDate = baseMapper.findTimelineByCursor(cursor);
        Long finalUserId = userId;
        List<PostSummaryVo> posts = baseMapper.findAllByCreatedDay(localDate)
                .stream()
                .map((post) -> fillPostSummary(finalUserId, post))
                .collect(Collectors.toList());
        
        boolean hasData = baseMapper.existsPostByLtCreatedDay(localDate);
        
        return new TimelinePostVo()
                .setDate(localDate)
                .setHasNextPage(hasData)
                .setPosts(posts);
    }
}
