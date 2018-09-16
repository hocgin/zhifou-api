package in.hocg.web.constant;

/**
 * Created by hocgin on 2018/8/23.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface SecurityConstants {
    
    /**
     * 验证码有效期5分钟
     */
    int VALIDATE_CODE_EXPIRE_IN = 5 * 60 * 1000;
    
    
    String SMS_VALIDATE_URLS = "/example/checkSMS";
    String IMAGE_VALIDATE_URLS = "/example/checkImageCode";
}
