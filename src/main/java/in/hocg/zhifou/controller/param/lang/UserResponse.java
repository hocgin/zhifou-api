package in.hocg.zhifou.controller.param.lang;

import in.hocg.zhifou.entity.User;
import lombok.Data;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class UserResponse {
    private String username;
    private String avatar = "https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png";
    private Long id;
    
    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
    
}
