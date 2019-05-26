package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.Banner;
import in.hocg.zhifou.pojo.vo.BannerVo;

import java.util.List;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface BannerService extends IService<Banner> {
    /**
     * 获取所有的 Banner
     *
     * @return
     */
    List<BannerVo> getAll();
}
