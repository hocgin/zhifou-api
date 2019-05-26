package in.hocg.zhifou.support.base.util;

import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public class Env {
    
    /**
     * 当前是否为开发环境
     *
     * @return
     */
    public static boolean isDev() {
        Environment environment = (Environment) SpringBean.getBean(Environment.class);
        String[] profiles = environment.getActiveProfiles();
        return Arrays.asList(profiles).contains("dev");
    }
}
