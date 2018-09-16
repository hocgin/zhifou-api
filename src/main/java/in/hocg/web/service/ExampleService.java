package in.hocg.web.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import in.hocg.base.util.http.GetPageCondition;
import in.hocg.web.pojo.domain.Example;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hocgin
 * @since 2018-06-11
 */
public interface ExampleService extends IService<Example> {
    
    /**
     * 分页🌰
     * @param condition
     * @return
     */
    Page<Example> page(GetPageCondition condition);
}
