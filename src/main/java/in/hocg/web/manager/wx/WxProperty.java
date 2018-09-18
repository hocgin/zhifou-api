package in.hocg.web.manager.wx;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 2018/9/10.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ToString
@Component
@ConfigurationProperties(value = "wechat")
public class WxProperty {
    private String appid;
    private String secret;
}
