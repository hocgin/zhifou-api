package in.hocg.web.pojo.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import in.hocg.base.support.scaffold.DeletedModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by hocgin on 2018/9/16.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ToString
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("t_wxer")
public class Wxer extends DeletedModel<Wxer> {
    
    @TableField(value = "open_id")
    private String openId;
    
    @TableField(value = "nick_name")
    private String nickName;
    
    @TableField(value = "gender")
    private int gender;
    
    @TableField(value = "language")
    private String language;
    
    @TableField(value = "city")
    private String city;
    
    @TableField(value = "province")
    private String province;
    
    @TableField(value = "country")
    private String country;
    
    @TableField(value = "avatar_url")
    private String avatarUrl;
    
    @TableField(value = "sign_up_ip")
    private String signUpIp;
    
    @TableField(value = "last_login_ip")
    private String lastLoginIp;
}
