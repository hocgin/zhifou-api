package in.hocg.zhifou.support.security;

import in.hocg.zhifou.service.UserService;
import in.hocg.zhifou.util.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by hocgin on 2018/10/19.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Component
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserService service;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        in.hocg.zhifou.domain.User user = service.findByUsername(username);
        if (Objects.isNull(user)) {
            throw ApiException.newInstance("用户账号或密码错误");
        }
        
        return new User(user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
