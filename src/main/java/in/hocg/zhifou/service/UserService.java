package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.config.security.JwtToken;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.pojo.ro.SignInRo;
import in.hocg.zhifou.pojo.ro.SignUpRo;

import java.security.Principal;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface UserService extends IService<User> {
    /**
     * 登陆
     *
     * @param param
     * @return
     */
    JwtToken signIn(SignInRo param);
    
    /**
     * 获取当前用户信息
     *
     * @param principal
     * @return
     */
    User getCurrentUserInfo(Principal principal);
    
    /**
     * 注册
     *
     * @param param
     */
    void signUp(SignUpRo param);
    
    /**
     * 查找用户信息
     *
     * @param username
     * @return
     */
    User findByUsername(String username);
    
}
