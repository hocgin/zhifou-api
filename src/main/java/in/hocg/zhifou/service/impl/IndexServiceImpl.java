package in.hocg.zhifou.service.impl;

import in.hocg.zhifou.manager.MailManager;
import in.hocg.zhifou.pojo.ro.SendEmailVerifyCodeRo;
import in.hocg.zhifou.service.IndexService;
import in.hocg.zhifou.util.CodeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class IndexServiceImpl implements IndexService {
    
    private final MailManager mailManager;
    
    @Override
    public void sendVerifyCode(SendEmailVerifyCodeRo param) {
        String code = CodeUtil.getRandom6Number();
        mailManager.sendVerifyCode(code, param.getEmail());
    }
}
