package in.hocg.zhifou.support.project;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by hocgin on 2019/5/4.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Configuration
@AllArgsConstructor
@PropertySource("classpath:config/project-${spring.profiles.active:dev}.properties")
@EnableConfigurationProperties(ProjectProperties.class)
public class ProjectAutoConfiguration implements InitializingBean {
    private final ProjectProperties properties;
    
    @Override
    public void afterPropertiesSet() {
        log.debug("加载自定义配置文件, 文件信息: {}", properties);
    }
}
