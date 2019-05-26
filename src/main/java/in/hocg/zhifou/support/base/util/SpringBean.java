package in.hocg.zhifou.support.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Component
public class SpringBean implements ApplicationContextAware {
    private static ApplicationContext APPLICATION_CONTEXT;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = applicationContext;
    }
    
    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }
    
    public static Object getBean(String beanId) throws BeansException {
        return APPLICATION_CONTEXT.getBean(beanId);
    }
    
    public static Object getBean(Class requiredType) throws BeansException {
        return APPLICATION_CONTEXT.getBean(requiredType);
    }
}
