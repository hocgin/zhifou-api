package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import in.hocg.zhifou.domain.Classify;
import in.hocg.zhifou.domain.Post;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.manager.RedisManager;
import in.hocg.zhifou.mapper.PostMapper;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.ro.SearchPostRo;
import in.hocg.zhifou.pojo.ro.TimelineQueryPostRo;
import in.hocg.zhifou.pojo.vo.*;
import in.hocg.zhifou.service.ClassifyService;
import in.hocg.zhifou.service.FavoriteService;
import in.hocg.zhifou.service.PostService;
import in.hocg.zhifou.service.UserService;
import in.hocg.zhifou.support.base.request.PageQuery;
import in.hocg.zhifou.support.mybatis.MybatisPlusKit;
import in.hocg.zhifou.util.ApiException;
import in.hocg.zhifou.util.Vid;
import in.hocg.zhifou.util.lang.StringKit;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    private final ClassifyService classifyService;
    private final RedisManager redisService;
    private final FavoriteService favoriteService;
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void published(PublishedPostRo param, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        if (Objects.isNull(user)) {
            throw ApiException.newInstance("请先进行登陆");
        }
        Post post = param.asPost();
        post.setAuthorId(user.getId());
        baseMapper.insert(post);
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
        
        String username = principal.getName();
        User user = userService.findByUsername(username);
        
        return fillPostDetail(user.getId(), post);
    }
    
    @Override
    public PostDetailVo fillPostDetail(Long userId, Post post) {
        if (Objects.isNull(post)) {
            return null;
        }
        
        PostDetailVo result = new PostDetailVo();
        BeanUtils.copyProperties(post, result);
        
        // 作者
        User author = userService.getById(post.getAuthorId());
        if (Objects.nonNull(author)) {
            result.setAuthor(new UserSummaryVo(author));
        }
        
        // 浏览量
        result.setPageviews(redisService.getPageviewsCount(String.valueOf(post.getId())));
        
        // 类别
        Classify classify = classifyService.getById(post.getClassifyId());
        if (Objects.nonNull(classify)) {
            result.setClassify(classify.getName());
        }
        
        String vid = Vid.encode(post.getId());
        result.setV(vid);
        
        // 设置相对路径
        result.setUri(String.format("/post?v=%s", vid));
        
        // 标签
        String tags = post.getTags();
        if (Objects.nonNull(tags)) {
            result.setTags(Sets.newHashSet(tags.split(",")));
        }
        
        // 图片
        String banner = post.getBanner();
        if (Objects.nonNull(banner)) {
            result.setBanner(Sets.newHashSet(banner.split(",")));
        }
        
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
        PostSummaryVo result = new PostSummaryVo();
        BeanUtils.copyProperties(post, result);
        
        // 作者
        User author = userService.getById(post.getAuthorId());
        if (Objects.nonNull(author)) {
            result.setAuthor(new UserSummaryVo(author));
        }
        
        // 浏览量
        result.setPageviews(redisService.getPageviewsCount(String.valueOf(post.getId())));
        
        // 类别
        Classify classify = classifyService.getById(post.getClassifyId());
        if (Objects.nonNull(classify)) {
            result.setClassify(classify.getName());
        }
        
        // 文章简介
        String content = post.getContent();
        result.setDesc(StringKit.desc(content, 255));
        
        // 业务ID
        String vid = Vid.encode(post.getId());
        result.setV(vid);
        
        // 文章路径
        result.setUri(String.format("/post?v=%s", vid));
        
        // 标签
        String tags = post.getTags();
        if (Objects.nonNull(tags)) {
            result.setTags(Sets.newHashSet(tags.split(",")));
        }
        
        // 图片
        String banner = post.getBanner();
        if (Objects.nonNull(banner)) {
            result.setBanner(Sets.newHashSet(banner.split(",")));
        }
        
        // 关联用户信息
        if (Objects.nonNull(userId)) {
            boolean alreadyFavorite = favoriteService.alreadyFavorite(userId, post.getId());
            result.setFavorites(alreadyFavorite);
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
