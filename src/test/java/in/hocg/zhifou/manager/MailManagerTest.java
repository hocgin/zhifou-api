package in.hocg.zhifou.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailManagerTest {
    
    @Autowired
    MailManager mailManager;
    
    @Test
    public void sendVerifyCode() {
        mailManager.sendVerifyCode("123", "578797748@qq.com");
    }
}