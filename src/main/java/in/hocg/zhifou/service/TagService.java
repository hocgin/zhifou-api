package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.Tag;
import in.hocg.zhifou.pojo.ro.SearchTagRo;

import java.util.List;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface TagService extends IService<Tag> {
    
    /**
     * 搜索标签
     * @param ro
     * @return
     */
    List<Tag> search(SearchTagRo ro);
}
