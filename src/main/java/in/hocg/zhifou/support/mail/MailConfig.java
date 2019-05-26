package in.hocg.zhifou.support.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Configuration
public class MailConfig {
    
    @Bean
    public MailTemplate mailTemplate(@Value("${spring.mail.username}") String username,
                                     JavaMailSender javaMailSender) {
        // 邮件服务
        return new MailTemplate(username, "官方邮件", javaMailSender);
    }
    
}
