package in.hocg.web.constant;

/**
 * Created by hocgin on 2018/8/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public enum ResultCode {
    NO_PERMISSION(201, "权限不足"),
    VERIFICATION_FAILED(202, "字段校验失败"),
    VALIDATE_CODE_FAILED(203, "校验码错误")
    ;
    private int code;
    private String message;
    
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
