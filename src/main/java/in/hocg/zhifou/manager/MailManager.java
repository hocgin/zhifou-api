package in.hocg.zhifou.manager;

import in.hocg.zhifou.support.mail.MailTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@AllArgsConstructor
@Service
public class MailManager {
    private final MailTemplate mailTemplate;
    
    public void sendVerifyCode() {
//        mailTemplate.send();
    }
}
