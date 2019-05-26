package in.hocg.zhifou.pojo.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("发送邮箱验证码")
public class SendEmailVerifyCodeRo {
    @NotBlank(message = "邮箱不能为空")
    @ApiModelProperty(value = "邮箱", required = true)
    private String email;
}
