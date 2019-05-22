package in.hocg.zhifou.service;

import in.hocg.zhifou.config.security.JwtToken;
import in.hocg.zhifou.controller.param.SignInParam;
import in.hocg.zhifou.controller.param.SignUpParam;
import in.hocg.zhifou.entity.User;

import java.security.Principal;
import java.util.Optional;

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
    
    /**
     * 查找用户信息
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username);
    
    /**
     * 查找用户信息
     * @param id
     * @return
     */
    Optional<User> findById(Long id);
    
}
