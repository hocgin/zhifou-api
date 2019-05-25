package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.*;
import lombok.experimental.Accessors;


/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User extends DefaultModel<Post> {
    
    @TableField
    private String username;
    @TableField
    private String email;
    @TableField
    private String password;
    
    /**
     * 邮箱验证状态 [未验证, 已验证]
     */
    @TableField
    @Builder.Default
    private Integer emailVerify = 0;
}
