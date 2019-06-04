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
    
    public static Page newPage(IPage iPage) {
        return new Page(iPage.getCurrent(), iPage.getSize(), iPage.getTotal(), iPage.isSearchCount());
    }
}
