package in.hocg.zhifou.pojo.vo;

import in.hocg.zhifou.domain.User;
import lombok.Data;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class UserVo {
    private String username;
    private String avatar = "https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png";
    private Long id;
    
    public UserVo(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
    
}
