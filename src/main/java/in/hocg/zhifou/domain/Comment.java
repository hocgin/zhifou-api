package in.hocg.zhifou.domain;

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
     * 评论目标 唯一标识
     * - 用字符串替代, 全局唯一标识来自于分配
     */
    @Column(nullable = false)
    private String targetId;
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
    
    /**
     * 创建时间
     */
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    /**
     * 更新时间
     */
    @Column
    private LocalDateTime updatedAt;
    
    /**
     * 删除时间
     */
    @Column
    private LocalDateTime deletedAt;
}
