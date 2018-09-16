package in.hocg.web.service.impl;

import in.hocg.base.support.scaffold.BaseService;
import in.hocg.web.mapper.WxerMapper;
import in.hocg.web.pojo.domain.Wxer;
import in.hocg.web.service.WxerService;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2018/9/16.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
public class WxerServiceImpl extends BaseService<WxerMapper, Wxer>
        implements WxerService {
    
    @Override
    public Wxer findByOpenId(String openId) {
        return selectOne(wrapper().eq("open_id", openId));
    }
    
}
