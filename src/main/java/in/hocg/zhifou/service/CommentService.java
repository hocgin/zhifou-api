package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.Comment;
import in.hocg.zhifou.pojo.ro.AddCommentRo;
import in.hocg.zhifou.pojo.vo.CommentVo;
import in.hocg.zhifou.support.base.request.PageQuery;

import java.security.Principal;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface CommentService extends IService<Comment> {
    /**
     * 评论
     *
     * @param principal
     * @param targetId
     * @param param
     */
    void comment(Principal principal,
                 String targetId,
                 AddCommentRo param);
    
    /**
     * 顶级评论
     *
     * @param targetId
     * @param pageable
     * @return
     */
    IPage<CommentVo> queryRootComment(String targetId,
                                      PageQuery<Void> pageable);
    
    /**
     * 子级评论
     *
     * @param targetId
     * @param rootId
     * @param pageable
     * @return
     */
    IPage<CommentVo> queryChildrenComment(String targetId,
                                          Long rootId,
                                          PageQuery<Void> pageable);
    
    
    /**
     * 查找评论
     * @param targetId
     * @param rootId
     * @param pageable
     * @return
     */
    IPage<Comment> findAllByTargetIdAndRootId(String targetId, Long rootId, IPage<Comment> pageable);
}
