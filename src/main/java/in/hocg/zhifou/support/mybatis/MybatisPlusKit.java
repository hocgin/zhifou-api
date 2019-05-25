package in.hocg.zhifou.support.mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public class MybatisPlusKit {
    
    public static <M> Page newPage(IPage<M> iPage) {
        return new Page<M>(iPage.getCurrent(), iPage.getSize(), iPage.getTotal(), iPage.isSearchCount());
    }
}
