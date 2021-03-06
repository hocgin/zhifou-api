package in.hocg.zhifou.service;

import in.hocg.zhifou.pojo.ro.SendEmailVerifyCodeRo;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface IndexService {
    
    /**
     * 发送验证码
     * @param param
     */
    void sendVerifyCode(SendEmailVerifyCodeRo param);
    
    /**
     * 上传文件
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
