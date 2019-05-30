package in.hocg.zhifou.support.base.request;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @param <C> 入参
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("查询对象")
public class PageQuery<C> extends AbstractPageQuery {
    @Valid
    @ApiModelProperty("条件")
    protected C condition;
    @ApiModelProperty("排序")
    private Map<String, String> sort = Maps.newHashMap();
    
    
    @Override
    protected Map<String, String> getSortMap() {
        return sort;
    }
    
    
    @JsonIgnore
    public Page page() {
        return new Page<>(page, size);
    }
    
    @JsonIgnore
    public QueryWrapper wrapper() {
        QueryWrapper wrapper = new QueryWrapper<>();
        Map<String, String> sortMap = getSortMap();
        if (sortMap.isEmpty()) {
            return wrapper;
        }
        sortMap.keySet().forEach(key -> {
            Optional.ofNullable(sortMap.get(key))
                    .ifPresent(value ->
                            wrapper.orderBy(true,
                                    "ASC".equalsIgnoreCase(value),
                                    CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, key)));
        });
        return wrapper;
    }
}
