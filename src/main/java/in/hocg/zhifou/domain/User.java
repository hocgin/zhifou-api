package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.domain.contant.UserConstant;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User extends DefaultModel<Post> {
    
    @TableField("username")
    private String username;
    @TableField("email")
    private String email;
    @TableField("password")
    private String password;
    
    /**
     * 邮箱验证状态 [未验证, 已验证]
     */
    @TableField("email_verify_status")
    private Integer emailVerifyStatus = UserConstant.EMAIL_VERIFY_STATUS_UNVERIFIED;
}
