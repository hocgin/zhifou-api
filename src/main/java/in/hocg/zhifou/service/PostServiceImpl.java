package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Sets;
import in.hocg.zhifou.domain.Classify;
import in.hocg.zhifou.domain.Post;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.mapper.PostMapper;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.vo.PostDetailVo;
import in.hocg.zhifou.pojo.vo.SearchPostVo;
import in.hocg.zhifou.pojo.vo.UserVo;
import in.hocg.zhifou.support.base.PageQuery;
import in.hocg.zhifou.support.mybatis.MybatisPlusKit;
import in.hocg.zhifou.support.redis.RedisService;
import in.hocg.zhifou.util.ApiException;
import in.hocg.zhifou.util.Vid;
import in.hocg.zhifou.util.lang.StringKit;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
        implements PostService {
    private final UserService userService;
    private final ClassifyService classifyService;
    private final RedisService redisService;
    
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
    public Page<SearchPostVo> search(PageQuery<Void> pageQuery) {
        Page page = pageQuery.page();
        QueryWrapper<Post> wrapper = pageQuery.wrapper();
        
        IPage<Post> result = baseMapper.selectPage(page, wrapper);
        
        List<SearchPostVo> list = result.getRecords().stream()
                .map((post) -> {
                    SearchPostVo response = new SearchPostVo();
                    BeanUtils.copyProperties(post, response);
                    
                    // 作者
                    User author = userService.getById(post.getAuthorId());
                    if (Objects.nonNull(author)) {
                        response.setAuthor(new UserVo(author));
                    }
                    
                    // 浏览量
                    response.setPageviews(redisService.getPageviewsCount(String.valueOf(post.getId())));
                    
                    // 分类
                    Classify classify = classifyService.getById(post.getClassifyId());
                    if (Objects.nonNull(classify)) {
                        response.setClassify(classify.getName());
                    }
                    
                    // 文章简介
                    String content = post.getContent();
                    response.setDesc(StringKit.desc(content, 255));
                    
                    response.setV(Vid.encode(post.getId()));
                    
                    String tags = post.getTags();
                    if (Objects.nonNull(tags)) {
                        response.setTags(Sets.newHashSet(tags.split(",")));
                    }
                    
                    String banner = post.getBanner();
                    if (Objects.nonNull(banner)) {
                        response.setBanner(Sets.newHashSet(banner.split(",")));
                    }
                    
                    return response;
                }).collect(Collectors.toList());
        
        Page<SearchPostVo> rtn = MybatisPlusKit.newPage(result);
        rtn.setRecords(list);
        return rtn;
    }
    
    @Override
    public PostDetailVo getPostDetail(String v) {
        Long id = Vid.decode(v);
        Post post = baseMapper.selectById(id);
        if (Objects.isNull(post)) {
            throw ApiException.newInstance("文章不存在");
        }
        
        PostDetailVo result = new PostDetailVo();
        
        BeanUtils.copyProperties(post, result);
        
        // 作者
        User author = userService.getById(post.getAuthorId());
        if (Objects.nonNull(author)) {
            result.setAuthor(new UserVo(author));
        }
        
        // 浏览量
        result.setPageviews(redisService.getPageviewsCount(String.valueOf(post.getId())));
        
        // 分类
        Classify classify = classifyService.getById(post.getClassifyId());
        if (Objects.nonNull(classify)) {
            result.setClassify(classify.getName());
        }
        
        String tags = post.getTags();
        if (Objects.nonNull(tags)) {
            result.setTags(Sets.newHashSet(tags.split(",")));
        }
        
        String banner = post.getBanner();
        if (Objects.nonNull(banner)) {
            result.setBanner(Sets.newHashSet(banner.split(",")));
        }
        
        return result;
    }
}
