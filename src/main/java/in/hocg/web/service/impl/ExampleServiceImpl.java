package in.hocg.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import in.hocg.base.support.scaffold.BaseService;
import in.hocg.base.util.http.GetPageCondition;
import in.hocg.web.mapper.ExampleMapper;
import in.hocg.web.pojo.domain.Example;
import in.hocg.web.service.ExampleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hocgin
 * @since 2018-06-11
 */
@Service
public class ExampleServiceImpl extends BaseService<ExampleMapper, Example>
        implements ExampleService {
    
    @Override
    public Page<Example> page(GetPageCondition condition) {
        EntityWrapper<Example> wrapper = condition.entityWrapper();
        Page<Example> page = condition.page();
        Optional<String> name = condition.getConditionOneValue("name");
        name.ifPresent(s->{
            wrapper.eq("name", s);
        });
    
        List<Example> list = baseMapper.selectPage(page, wrapper);
        return page.setRecords(list);
    }
}
