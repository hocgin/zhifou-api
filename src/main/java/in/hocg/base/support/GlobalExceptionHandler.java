package in.hocg.base.support;

import in.hocg.base.util.http.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author hocgin
 * @date 2018/6/18
 * email: hocgin@gmail.com
 * 异常处理
 */
@Profile({"prod", "test"})
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity handle(Exception e) {
        log.error(e.getLocalizedMessage());
        return Result.error(e.getLocalizedMessage())
                .setData(e.getClass().getName())
                .asResponseEntity();
    }
    
}
