package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.SuperModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/6/9.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@TableName("t_post_browsing_log")
@ApiModel("文章浏览记录表")
public class PostBrowsingLog extends SuperModel<PostBrowsingLog> {
    
    @TableField("post_id")
    @ApiModelProperty(value = "文章 ID", required = true)
    private Long postId;
    
    @TableField("user_id")
    @ApiModelProperty(value = "用户 ID", required = true)
    private Long userId;
    
    @TableField("created_at")
    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createdAt = LocalDateTime.now();
}
