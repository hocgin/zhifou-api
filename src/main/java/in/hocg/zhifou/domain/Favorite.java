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
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@ApiModel("用户收藏表")
@TableName("t_favorite")
public class Favorite extends SuperModel<Favorite> {
    
    @TableField("user_id")
    @ApiModelProperty(value = "用户 ID", required = true)
    private Long userId;
    
    @TableField("post_id")
    @ApiModelProperty(value = "文章 ID", required = true)
    private Long postId;
    
    @TableField("created_at")
    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createdAt = LocalDateTime.now();
}
