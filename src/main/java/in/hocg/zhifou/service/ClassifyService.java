package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.Classify;
import in.hocg.zhifou.pojo.ro.SearchClassifyRo;
import in.hocg.zhifou.pojo.vo.SearchClassifyVo;

import java.util.List;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface ClassifyService extends IService<Classify> {
    /**
     * 搜索分类
     *
     * @param param
     * @return
     */
    List<SearchClassifyVo> search(SearchClassifyRo param);
}
