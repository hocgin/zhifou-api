package in.hocg.zhifou.pojo.ro;

import in.hocg.zhifou.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 * 注册
 *
 * @author hocgin
 */
@Data
@ApiModel("注册")
public class SignUpRo {
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(value = "邮箱", required = true)
    private String email;
    
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    
    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码", required = true)
    private String code;
    
    
    public User asUser() {
        User entity = new User();
        entity.setUsername(username);
        entity.setEmail(email);
        entity.setPassword(password);
        return entity;
    }
}
