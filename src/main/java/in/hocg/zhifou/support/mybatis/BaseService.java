package in.hocg.zhifou.support.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public abstract class BaseService<E, R extends BaseMapper<E>> extends ServiceImpl<R, E> {

}
