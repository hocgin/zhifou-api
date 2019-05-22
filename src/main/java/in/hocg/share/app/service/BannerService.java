package in.hocg.share.app.service;

import in.hocg.share.app.controller.param.BannerResponse;

import java.util.List;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface BannerService {
    /**
     * 获取所有的 Banner
     * @return
     */
    List<BannerResponse> getAll();
}
