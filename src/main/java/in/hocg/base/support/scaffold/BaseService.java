package in.hocg.base.support.scaffold;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * ExampleMapper, Example
 * @author hocgin
 * @param <M> Mapper 接口
 * @param <T> 对象实体
 *
 */
public abstract class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
    
    
    protected Wrapper<T> wrapper() {
        return new EntityWrapper<>();
    }
}
