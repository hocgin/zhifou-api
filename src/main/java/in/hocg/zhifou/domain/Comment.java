package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@ApiModel("评论表")
@TableName("t_comment")
public class Comment extends DefaultModel<Comment> {
    
    @TableField("content")
    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
    
    @TableField("target_id")
    @ApiModelProperty(value = "评论目标 唯一标识, 全局唯一标识来自于分配", required = true)
    private String targetId;
    
    @TableField("root_id")
    @ApiModelProperty(value = "根评论 ID", required = true)
    private Long rootId;

    @TableField("parent_id")
    @ApiModelProperty("父评论 ID")
    private Long parentId;
    
}
