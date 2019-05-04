package in.hocg.share.app.config.redis;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019/5/4.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class RedisService {
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
}
