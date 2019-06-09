package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.pojo.vo.TokenVo;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.pojo.ro.SignInRo;
import in.hocg.zhifou.pojo.ro.SignUpRo;
import in.hocg.zhifou.pojo.vo.UserSummaryVo;

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
    TokenVo signIn(SignInRo param);
    
    /**
     * 获取当前用户信息
     *
     * @param principal
     * @return
     */
    UserSummaryVo getCurrentUserInfo(Principal principal);
    
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
