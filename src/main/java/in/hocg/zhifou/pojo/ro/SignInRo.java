package in.hocg.zhifou.pojo.ro;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class SignInRo {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
