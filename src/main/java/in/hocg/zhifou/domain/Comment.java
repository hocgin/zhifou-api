package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_comment")
public class Comment extends DefaultModel<Comment> {
    
    /**
     * 评论内容
     */
    @TableField
    private String content;
    /**
     * 评论目标 唯一标识
     * - 用字符串替代, 全局唯一标识来自于分配
     */
    @TableField
    private String targetId;
    /**
     * 评论者
     */
    @TableField
    private Long userId;
    /**
     * 根评论
     */
    @TableField
    private Long rootId;
    /**
     * 父评论
     */
    @TableField
    private Long parentId;
    
}
