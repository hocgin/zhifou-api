package in.hocg.share.app.service;

import in.hocg.share.app.config.security.JwtToken;
import in.hocg.share.app.controller.param.SignInParam;
import in.hocg.share.app.controller.param.SignUpParam;
import in.hocg.share.app.entity.User;

import java.security.Principal;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface UserService {
    /**
     * 登陆
     * @param param
     */
    JwtToken signIn(SignInParam param);
    
    /**
     * 获取当前用户信息
     * @param principal
     * @return
     */
    User getCurrentUserInfo(Principal principal);
    
    /**
     * 注册
     * @param param
     */
    void signUp(SignUpParam param);
}
