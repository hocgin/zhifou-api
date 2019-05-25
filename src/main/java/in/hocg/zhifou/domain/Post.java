package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 * 文章
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_post")
public class Post extends DefaultModel<Post> {
    /**
     * 标题图
     */
    @TableField
    private String banner;
    
    /**
     * 标题
     */
    @TableField
    private String title;
    
    /**
     * HTML 文本
     */
    @TableField
    private String content;
    
    /**
     * 标签
     * eg: xx,xx,xx
     */
    @TableField
    private String tags;
    
    /**
     * 作者ID
     */
    @TableField
    private Long authorId;
    
    /**
     * 类别ID
     */
    @TableField
    private Long classifyId;
    
    /**
     * 点赞数
     */
    @TableField
    @Builder.Default
    private Long liked = 0L;
    
    /**
     * 是否允许评论
     */
    @TableField
    @Builder.Default
    private boolean hasCommend = true;
    
    /**
     * 创建时间
     */
    @TableField
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    
    /**
     * 更新时间
     */
    @TableField
    private LocalDateTime updatedAt;
    
    /**
     * 删除时间
     */
    @TableField
    private LocalDateTime deletedAt;
}
