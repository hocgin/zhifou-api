package in.hocg;

import com.alibaba.druid.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.util.DigestUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hocgin on 2018/6/17.
 * email: hocgin@gmail.com
 */
@RunWith(JUnit4.class)
public class CsrfTests {
    
    @Test
    public void testCsrf() {
        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("q", new String[]{"skdj", "sd"});
        // 必传
        parameterMap.put("timestamp", new String[]{"1529207051235"});
        parameterMap.put("sign", new String[]{"872ff3d197bc70ca63b9d0dfd968fb2e"});
    
    
        String values = parameterMap.keySet().stream()
                .filter(key -> !StringUtils.equals(key, "sign"))
                .flatMap(key -> Arrays.stream(parameterMap.get(key)))
                .reduce((i, j) -> i + j)
                .orElse("");
        String sign = DigestUtils.md5DigestAsHex(values.getBytes());
        StringUtils.equals(parameterMap.get("sign")[0], sign);
        System.out.println(String.format("md5(%s)=%s\nsign=%s", values, sign, parameterMap.get("sign")));
    }
    
    @Test
    public void testTimestamp() {
    
//        long tmp = Long.valueOf("15292091 59956");
        
        long tmp = Long.valueOf("1529209189956");
        Date date = new Date();
        date.setTime(tmp);
        System.out.println(date);
    }
}
