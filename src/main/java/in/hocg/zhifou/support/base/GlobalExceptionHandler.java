package in.hocg.zhifou.support.base;

import in.hocg.zhifou.util.ApiException;
import in.hocg.zhifou.util.http.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


/**
 * @author hocgin
 * @date 2018/6/18
 * email: hocgin@gmail.com
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
    
    /**
     * 业务型异常
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ResponseEntity apiException(HttpServletRequest request, ApiException e) throws Exception {
        log.error("API 异常: {}", e);
        return Result.error(e.getMessage())
                .setCode(e.getCode())
                .asResponseEntity();
    }
    
    /**
     * 接口参数校验失败
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) throws Exception {
        log.error("API 参数校验失败: {}", e);
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        return Result.error(fieldError.getDefaultMessage())
                .asResponseEntity();
    }
    
    /**
     * 默认异常处理
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity handle(HttpServletRequest request, Exception e) throws Exception {
        log.error("默认异常处理: {}", e);
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        
        String message = e.getLocalizedMessage();
        return Result.error(message)
                .asResponseEntity();
    }
    
}
