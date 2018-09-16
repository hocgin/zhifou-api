package in.hocg.web.support.base.aspect.log;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.hocg.base.util.RequestKit;
import in.hocg.base.util.ResponseKit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by hocgin on 2017/11/17.
 * email: hocgin@gmail.com
 *
 * @ILog 处理
 */
@Aspect
@Component
@Slf4j
public class ILogAspect {
    private ObjectMapper objectMapper;
    private HttpServletRequest request;
    
    @Autowired
    public ILogAspect(ObjectMapper objectMapper,
                      HttpServletRequest request) {
        this.request = request;
        this.objectMapper = objectMapper;
    }
    
    @Pointcut("execution(* in.hocg..*(..)) && @annotation(in.hocg.web.support.base.aspect.log.ILog)")
    public void logPointcut() {
    }
    
    @Around("logPointcut()")
    public Object logHandler(ProceedingJoinPoint point) {
        StopWatch watch = new StopWatch();
        watch.start();
        
        Object result = null;
        try {
            result = point.proceed();
            doLog(watch, point, result, null);
        } catch (Throwable throwable) {
            doLog(watch, point, null, throwable);
            throwable.printStackTrace();
        }
        return result;
    }
    
    private void doLog(StopWatch watch, ProceedingJoinPoint point, Object result, Throwable e) {
        watch.stop();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        ILog annotation = method.getAnnotation(ILog.class);
        Class aClass = point.getSourceLocation().getWithinType();
        String src = String.format("%s#%s", aClass.getName(), method.getName());
        
        String msg = annotation.message();
        try {
            SpelParserConfiguration config = new SpelParserConfiguration(true, true);
            ExpressionParser parser = new SpelExpressionParser(config);
            StandardEvaluationContext context = new StandardEvaluationContext();
            context.setVariable("args", point.getArgs());
            context.setVariable("request", RequestKit.get());
            context.setVariable("response", ResponseKit.get());
            context.setVariable("return", result);
            Expression expression = parser.parseExpression(msg);
            msg = expression.getValue(context, String.class);
        } catch (Throwable ignored) {
        }
        
        log.debug("[日志信息]来源:{}\n信息:{}\n耗时:{}ms", src, msg, watch.getLastTaskTimeMillis());
    }
}
