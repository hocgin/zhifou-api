package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.Website;

import java.util.List;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface WebsiteService extends IService<Website> {
    
    /**
     * 根据 文章ID 获取关联的站点
     * @param id
     * @return
     */
    List<Website> findByPostId(Long id);
}
