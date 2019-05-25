package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.support.security.JwtToken;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.mapper.UserMapper;
import in.hocg.zhifou.pojo.ro.SignInRo;
import in.hocg.zhifou.pojo.ro.SignUpRo;
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
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public JwtToken signIn(SignInRo param) {
        String username = param.getUsername();
        String password = param.getPassword();
        
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                username,
                password
        );
        
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.generateToken(authentication);
        return new JwtToken(token);
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
        String username = param.getUsername();
        String password = param.getPassword();
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
        return baseMapper.selectOne(lambdaQuery().eq(User::getUsername, username));
    }
    
}
