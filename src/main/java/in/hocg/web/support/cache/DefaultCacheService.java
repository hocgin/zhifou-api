package in.hocg.web.support.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author hocgin
 * @date 18-8-20
 **/
@Component
public class DefaultCacheService implements CacheService {
    private final RedisTemplate<Object, Object> redisTemplate;
    
    @Autowired
    public DefaultCacheService(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
    @Override
    public void set(Object key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }
    
    @Override
    public boolean contains(Object key) {
        return redisTemplate.opsForValue().get(key) != null;
    }
    
    @Override
    public Optional<Object> get(Object key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key));
    }
    
    @Override
    public void delete(Object key) {
        redisTemplate.delete(key);
    }
}
