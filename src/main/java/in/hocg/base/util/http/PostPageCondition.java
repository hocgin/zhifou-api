package in.hocg.base.util.http;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.CaseFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

/**
 * Created by hocgin on 2018/8/26.
 * email: hocgin@gmail.com
 * <p>
 * 请求方式: POST
 * 内容: application/json
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostPageCondition<T> extends PageCondition {
    @Valid
    private T condition;
    private Map<String, String> sort;
    
    /**
     * ======================================
     * 结合 Mybatis Plus
     * ======================================
     */
    @JsonIgnore
    public <T> Page<T> page() {
        return new Page<>(page, limit);
    }
    
    @JsonIgnore
    public <T> EntityWrapper<T> entityWrapper() {
        EntityWrapper<T> wrapper = new EntityWrapper<>();
        sort.keySet().forEach(key -> Optional.ofNullable(sort.get(key)).ifPresent(value ->
                wrapper.orderBy(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, key),
                        "ASC".equalsIgnoreCase(value))));
        return wrapper;
    }
}
