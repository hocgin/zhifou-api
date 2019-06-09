package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
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
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@TableName("t_user")
@ApiModel("用户表")
public class User extends SuperModel<User> {
    
    @TableField("username")
    @ApiModelProperty(value = "用户名，唯一", required = true)
    private String username;
    
    @TableField("email")
    @ApiModelProperty(value = "邮箱，唯一", required = true)
    private String email;
    
    @TableField("password")
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    
    @TableField("created_at")
    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @TableField(value = "updated_at", update = "NOW()", fill = FieldFill.UPDATE)
    @ApiModelProperty("更新时间")
    private LocalDateTime updatedAt;
}
