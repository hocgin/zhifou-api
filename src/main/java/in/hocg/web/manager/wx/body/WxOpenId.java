package in.hocg.web.manager.wx.body;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by hocgin on 2018/9/12.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ToString
public class WxOpenId implements Serializable {
    
    /**
     * session_key : CNmuPMGlGsvqQO7NztW89Q==
     * openid : oyRKu4jS6SKlz6wS3mC9zpZk2QXo
     */
    @JsonProperty("session_key")
    private String sessionKey;
    private String openid;
}
