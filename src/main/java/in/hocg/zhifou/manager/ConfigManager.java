package in.hocg.zhifou.manager;

import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 2019/6/3.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Component
public class ConfigManager {
    
    public String getImageServer() {
        return "https://daigou-test.oss-cn-beijing.aliyuncs.com";
    }
}
