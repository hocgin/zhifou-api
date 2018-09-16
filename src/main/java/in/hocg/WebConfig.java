package in.hocg;

import in.hocg.web.support.base.interceptor.AntiReplayInterceptor;
import in.hocg.web.support.base.json.JsonReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 *
 * @author hocgin
 * @date 2018/6/17
 * email: hocgin@gmail.com
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    private final AntiReplayInterceptor antiReplayInterceptors;
    private final JsonReturnValueHandler jsonReturnValueHandler;
    
    @Autowired
    public WebConfig(AntiReplayInterceptor antiReplayInterceptors,
                     JsonReturnValueHandler jsonReturnValueHandler) {
        this.antiReplayInterceptors = antiReplayInterceptors;
        this.jsonReturnValueHandler = jsonReturnValueHandler;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        
        // 防重放攻击
//        registry.addInterceptor(antiReplayInterceptors)
//                .addPathPatterns("/**");
    }
    
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        returnValueHandlers.add(jsonReturnValueHandler);
    }
}
