package in.hocg.zhifou.util;

import lombok.Getter;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Getter
public class ApiException extends RuntimeException {
    private final int code;
    
    public ApiException(String message) {
        this(500, message);
    }
    
    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }
    
    public static ApiException newInstance(String message) {
        return new ApiException(message);
    }
}
