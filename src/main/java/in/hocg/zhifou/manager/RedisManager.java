package in.hocg.zhifou.manager;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by hocgin on 2019/5/4.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Service
@AllArgsConstructor
public class RedisManager {
    private final StringRedisTemplate template;
    
    /**
     * 浏览量自增
     *
     * @param id
     */
    public void increasePageviews(String id) {
        ValueOperations<String, String> opsForValue = template.opsForValue();
        opsForValue.increment(id, 1);
    }
    
    /**
     * 获取浏览量
     *
     * @param id
     * @return
     */
    public long getPageviewsCount(String id) {
        ValueOperations<String, String> opsForValue = template.opsForValue();
        String val = opsForValue.get(id);
        if (val == null) {
            return 0L;
        }
        try {
            return Long.parseLong(val);
        } catch (NumberFormatException e) {
            return 1L;
        }
    }
    
    /**
     * 存储注册验证码
     *
     * @return
     */
    public void setVerifyCode(String email, String code) {
        ValueOperations<String, String> opsForValue = template.opsForValue();
        opsForValue.set(email, code, 5, TimeUnit.MINUTES);
        log.debug("验证码设置[邮箱: {}, 验证码: {}]", email, code);
    }
    
    /**
     * 获取注册验证码
     *
     * @param email
     * @return
     */
    public String getVerifyCode(String email) {
        ValueOperations<String, String> opsForValue = template.opsForValue();
        String code = opsForValue.get(email);
        log.debug("验证码获取[邮箱: {}, 验证码: {}]", email, code);
        return code;
    }
}
