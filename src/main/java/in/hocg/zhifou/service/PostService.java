package in.hocg.zhifou.service;

import in.hocg.zhifou.controller.param.PostDetailResponse;
import in.hocg.zhifou.controller.param.PublishedPostParam;
import in.hocg.zhifou.controller.param.SearchPostResponse;
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
    void published(PublishedPostParam param, Principal principal);
    
    /**
     * 查询文章列表
     * @param pageable
     * @return
     */
    Page<SearchPostResponse> search(Pageable pageable);
    
    /**
     * 文章详情
     * @param v
     * @return
     */
    PostDetailResponse getPostDetail(String v);
}
