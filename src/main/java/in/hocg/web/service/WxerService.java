package in.hocg.web.service;

import com.baomidou.mybatisplus.service.IService;
import in.hocg.web.pojo.domain.Wxer;

/**
 * Created by hocgin on 2018/9/16.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface WxerService extends IService<Wxer> {
    
    /**
     * 使用微信 OpenId 查找用户
     *
     * @param openId
     * @return
     */
    Wxer findByOpenId(String openId);
}
