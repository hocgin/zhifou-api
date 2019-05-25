package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.Post;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.vo.PostDetailVo;
import in.hocg.zhifou.pojo.vo.SearchPostVo;
import in.hocg.zhifou.support.base.PageQuery;

import java.security.Principal;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface PostService extends IService<Post> {
    
    /**
     * 发布文章
     * @param param
     * @param principal
     */
    void published(PublishedPostRo param, Principal principal);
    
    /**
     * 查询文章列表
     * @param query
     * @return
     */
    IPage<SearchPostVo> search(PageQuery<Void> query);
    
    /**
     * 文章详情
     * @param v
     * @return
     */
    PostDetailVo getPostDetail(String v);
}
