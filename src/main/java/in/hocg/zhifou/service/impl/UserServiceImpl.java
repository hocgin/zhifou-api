package in.hocg.zhifou.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.manager.RedisManager;
import in.hocg.zhifou.mapper.UserMapper;
import in.hocg.zhifou.pojo.ro.SignInRo;
import in.hocg.zhifou.pojo.ro.SignUpRo;
import in.hocg.zhifou.pojo.vo.TokenVo;
import in.hocg.zhifou.service.UserService;
import in.hocg.zhifou.support.base.util.Env;
import in.hocg.zhifou.util.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.visola.spring.security.tokenfilter.TokenService;

import java.security.Principal;
import java.util.Objects;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final RedisManager redisManager;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public TokenVo signIn(SignInRo param) {
        String username = param.getUsername();
        String password = param.getPassword();
        
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                username,
                password
        );
        
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.generateToken(authentication);
        return new TokenVo(token);
    }
    
    @Override
    public User getCurrentUserInfo(Principal principal) {
        String username = principal.getName();
        User user = findByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("未找到用户信息");
        }
        
        // 屏蔽密码
        user.setPassword(null);
        return user;
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpRo param) {
        String code = param.getCode();
        String email = param.getEmail();
        String username = param.getUsername();
        String password = param.getPassword();
        
        
        if (!Env.isDev()) {
            // 验证码判断
            String verifyCode = redisManager.getVerifyCode(email);
            if (!StringUtils.equals(verifyCode, code)) {
                throw ApiException.newInstance("验证码错误");
            }
        }
        
        // 用户判断
        if (Objects.nonNull(findByUsername(username))) {
            throw ApiException.newInstance("用户已经存在");
        }
        User user = param.asUser();
        
        String passwordEncode = passwordEncoder.encode(password);
        user.setPassword(passwordEncode);
        
        baseMapper.insert(user);
    }
    
    @Override
    public User findByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        return baseMapper.selectOne(wrapper.eq(User::getUsername, username));
    }
    
    
}
