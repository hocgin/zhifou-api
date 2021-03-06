package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.SuperModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@TableName("t_post_tag_ref")
@ApiModel("文章-标签关联表")
public class PostTagRef extends SuperModel<PostTagRef> {
    
    @TableField("post_id")
    @ApiModelProperty(value = "文章 ID", required = true)
    private Long postId;
    
    @TableField("tag_id")
    @ApiModelProperty(value = "标签 ID", required = true)
    private Long tagId;
}
