package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_comment")
public class Comment extends DefaultModel<Comment> {
    
    @TableField("content")
    @ApiModelProperty("评论内容")
    private String content;
    
    @ApiModelProperty("评论目标 唯一标识, 全局唯一标识来自于分配")
    @TableField("target_id")
    private String targetId;
    
    @ApiModelProperty("根评论 ID")
    @TableField("root_id")
    private Long rootId;

    @ApiModelProperty("父评论 ID")
    @TableField("parent_id")
    private Long parentId;
    
}
