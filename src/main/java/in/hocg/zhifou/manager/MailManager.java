package in.hocg.zhifou.manager;

import com.google.common.collect.Maps;
import in.hocg.zhifou.support.mail.MailTemplate;
import in.hocg.zhifou.support.thymeleaf.ThymeleafParser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@AllArgsConstructor
@Service
public class MailManager {
    private final MailTemplate mailTemplate;
    private final ThymeleafParser thymeleafParser;
    private final RedisManager redisManager;
    
    public void sendVerifyCode(String code, String toEmail) {
        Assert.notNull(code, "验证码不能为空");
        Assert.notNull(toEmail, "邮箱不能为空");
        
        HashMap<String, Object> params = Maps.newHashMap();
        params.put("code", code);
        String html = thymeleafParser.thymeleafTemplate("verify-code", params);
        try {
            mailTemplate.send(toEmail, "来自 hocg.in 的验证码", html);
        } catch (UnsupportedEncodingException | MessagingException e) {
            log.error("邮件发送失败:", e);
        }finally {
            redisManager.setVerifyCode(toEmail, code);
        }
    }
}
