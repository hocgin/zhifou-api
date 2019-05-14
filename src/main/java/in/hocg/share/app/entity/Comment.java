package in.hocg.share.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 评论内容
     */
    @Column
    private String content;
    /**
     * 评论目标
     */
    @Column(nullable = false)
    private Long targetId;
    /**
     * 评论者
     */
    @Column(nullable = false)
    private Long userId;
    /**
     * 根评论
     */
    @Column
    private Long rootId;
    /**
     * 父评论
     */
    @Column
    private Long parentId;
    
    
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column
    private LocalDateTime updatedAt;
    @Column
    private LocalDateTime deletedAt;
}
