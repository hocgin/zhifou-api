package in.hocg.share.app.controller.param;

import in.hocg.share.app.entity.Comment;
import in.hocg.share.app.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class CommentResponse {
    
    public CommentResponse(Comment comment) {
        BeanUtils.copyProperties(comment, this);
    }
    
    private Long id;
    
    /**
     * 评论内容
     */
    private String content;
    
    /**
     * 文章
     */
    private Long targetId;
    
    /**
     * 根级评论ID
     */
    private Long rootId;
    
    /**
     * 父级评论ID
     */
    private Long parentId;
    
    /**
     * 评论者
     */
    private Commenter commenter;
    
    /**
     * 被评论者
     */
    private Commenter pCommenter;
    
    /**
     * 子评论
     */
    private Page<CommentResponse> children;
    
    @Data
    public static class Commenter {
        private String username;
        
        public Commenter(User user) {
            this.username = user.getUsername();
        }
    }
}
