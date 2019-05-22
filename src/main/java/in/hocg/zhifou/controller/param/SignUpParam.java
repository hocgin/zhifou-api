package in.hocg.zhifou.controller.param;

import in.hocg.zhifou.entity.User;
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
public class SignUpParam {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    
    
    public User asUser() {
        User entity = new User();
        entity.setUsername(username);
        entity.setPassword(password);
        return entity;
    }
}
