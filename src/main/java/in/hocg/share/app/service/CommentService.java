package in.hocg.share.app.service;

import in.hocg.share.app.controller.param.CommentParam;
import in.hocg.share.app.controller.param.CommentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface CommentService {
    /**
     * 评论
     *
     * @param principal
     * @param targetId
     * @param param
     */
    void comment(Principal principal,
                 String targetId,
                 CommentParam param);
    
    /**
     * 顶级评论
     *
     * @param targetId
     * @param pageable
     * @return
     */
    Page<CommentResponse> queryRootComment(String targetId,
                                           Pageable pageable);
    
    /**
     * 子级评论
     *
     * @param targetId
     * @param rootId
     * @param pageable
     * @return
     */
    Page<CommentResponse> queryChildrenComment(String targetId,
                                               Long rootId,
                                               Pageable pageable);
    
}
