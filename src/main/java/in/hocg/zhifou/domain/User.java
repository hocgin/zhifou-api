package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.SuperModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User extends SuperModel<User> {
    
    @TableField("username")
    private String username;
    
    @TableField("email")
    private String email;
    
    @TableField("password")
    private String password;
    
    @TableField("created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @TableField(value = "updated_at", update = "NOW()", fill = FieldFill.UPDATE)
    private LocalDateTime updatedAt;
}
