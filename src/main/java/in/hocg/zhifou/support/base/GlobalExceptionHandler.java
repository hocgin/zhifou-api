package in.hocg.zhifou.support.base;

import in.hocg.zhifou.util.ApiException;
import in.hocg.zhifou.util.http.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


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
        log.error("API 异常:", e);
        return Result.error(e.getMessage())
                .setCode(e.getCode())
                .asResponseEntity();
    }
    
    /**
     * 业务型异常
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MailSendException.class)
    @ResponseBody
    public ResponseEntity mailSendException(HttpServletRequest request, MailSendException e) throws Exception {
        log.error("邮件发送异常:", e);
        return Result.error("邮件发送失败")
                .asResponseEntity();
    }
    
    @ExceptionHandler(value = SQLException.class)
    @ResponseBody
    public ResponseEntity SQLException(HttpServletRequest request, SQLException e) throws Exception {
        log.error("SQL异常:", e);
        return Result.error("系统异常")
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
        log.error("API 参数校验失败:", e);
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
        log.error("默认异常处理:", e);
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        
        String message = e.getLocalizedMessage();
        return Result.error(message)
                .asResponseEntity();
    }
    
}
