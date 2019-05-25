package in.hocg.zhifou.service;

import in.hocg.zhifou.pojo.vo.PostDetailVo;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.vo.SearchPostVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface PostService {
    
    /**
     * 发布文章
     * @param param
     * @param principal
     */
    void published(PublishedPostRo param, Principal principal);
    
    /**
     * 查询文章列表
     * @param pageable
     * @return
     */
    Page<SearchPostVo> search(Pageable pageable);
    
    /**
     * 文章详情
     * @param v
     * @return
     */
    PostDetailVo getPostDetail(String v);
}
