package in.hocg.zhifou.pojo.ro;

import in.hocg.zhifou.domain.User;
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
public class SignUpRo {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "邮箱不能为空")
    private String email;
    @NotBlank(message = "密码不能为空")
    private String password;
    
    
    public User asUser() {
        User entity = new User();
        entity.setUsername(username);
        entity.setEmail(email);
        entity.setPassword(password);
        return entity;
    }
}
