package in.hocg.zhifou.support.mail;

import in.hocg.zhifou.support.base.util.Env;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTemplateTest {
    
    @Autowired
    MailTemplate mailTemplate;
    
    @Test
    public void send() throws UnsupportedEncodingException, MessagingException {
        if (!Env.isDev()) {
            mailTemplate.send("578797748@qq.com", "hocg.in 官方邮件", "<body>你好</body>");
        }
    }
}