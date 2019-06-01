package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.Post;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.ro.SearchPostRo;
import in.hocg.zhifou.pojo.ro.TimelineQueryPostRo;
import in.hocg.zhifou.pojo.vo.PostDetailVo;
import in.hocg.zhifou.pojo.vo.PostSummaryVo;
import in.hocg.zhifou.pojo.vo.TimelinePostVo;
import in.hocg.zhifou.support.base.request.PageQuery;

import java.security.Principal;
import java.util.List;
import java.util.Map;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface PostService extends IService<Post> {
    
    /**
     * 发布文章
     *
     * @param param
     * @param principal
     */
    void published(PublishedPostRo param, Principal principal);
    
    /**
     * 分页查询文章列表
     *
     * @param principal
     * @param query
     * @return
     */
    IPage<PostSummaryVo> paging(Principal principal, PageQuery<Void> query);
    
    
    /**
     * 查询文章列表
     *
     * @param principal
     * @param query
     * @return
     */
    List<PostSummaryVo> search(Principal principal, SearchPostRo query);
    
    /**
     * 文章详情
     *
     * @param principal
     * @param v
     * @return
     */
    PostDetailVo getPostDetail(Principal principal, String v);
    
    /**
     * 填充文章详情
     * @param userId
     * @param post
     * @return
     */
    PostDetailVo fillPostDetail(Long userId, Post post);
    
    /**
     * 填充文章概要
     * @param userId 可选, 关联用户的 ID
     * @param post 文章
     * @return
     */
    PostSummaryVo fillPostSummary(Long userId, Post post);
    
    /**
     * 按时间线来获取文章
     * @param principal
     * @param query
     * @return
     */
    @Deprecated
    Map<Integer, List<PostSummaryVo>> findAllByTimeline(Principal principal, TimelineQueryPostRo query);
    
    /**
     * 按时间线来获取文章
     * @param principal
     * @param query
     * @return
     */
    TimelinePostVo findPostsByTimeline(Principal principal, TimelineQueryPostRo query);
}
