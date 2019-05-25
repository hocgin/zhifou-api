package in.hocg.zhifou.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 * 文章
 *
 * @author hocgin
 */
@Data
@Entity
@Table(name = "t_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 标题图
     */
    @Column
    private String banner;
    
    /**
     * 标题
     */
    @Column(nullable = false)
    private String title;
    
    /**
     * HTML 文本
     */
    @Column(nullable = false)
    private String content;
    
    /**
     * 标签
     * eg: xx,xx,xx
     */
    @Column
    private String tags;
    
    /**
     * 作者ID
     */
    @Column(nullable = false)
    private Long authorId;
    
    /**
     * 类别ID
     */
    @Column(nullable = false)
    private Long classifyId;
    
    /**
     * 点赞数
     */
    @Column(nullable = false)
    private Long liked = 0L;
    
    /**
     * 是否允许评论
     */
    @Column(nullable = false)
    private boolean hasCommend = true;
    
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
