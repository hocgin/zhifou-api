package in.hocg.zhifou.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import in.hocg.zhifou.domain.Comment;
import in.hocg.zhifou.support.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class CommentVo {
    
    public CommentVo(Comment comment) {
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
    private UserVo commenter;
    
    /**
     * 被评论者
     */
    private UserVo pCommenter;
    
    /**
     * 子评论数量
     */
    private Long commentCount;
    
    /**
     * 创建时间
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
}
