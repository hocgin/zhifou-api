package in.hocg.zhifou.support.spel;

import com.google.common.collect.Maps;
import in.hocg.zhifou.support.thymeleaf.ThymeleafParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ThymeleafParserTest {
    @Autowired
    ThymeleafParser thymeleafParser;
    
    @Test
    public void thymeleafTemplate() {
        HashMap<String, Object> params = Maps.newHashMap();
        params.put("books", "nice");
        String thymeleaf = thymeleafParser.thymeleafTemplate("test", params);
        System.out.println(thymeleaf);
    }
}