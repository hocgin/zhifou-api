package in.hocg.zhifou.config.security;

import in.hocg.zhifou.repository.UserRepository;
import in.hocg.zhifou.util.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by hocgin on 2018/10/19.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Component
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<in.hocg.zhifou.entity.User> userOptional = repository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new ApiException("用户账号或密码错误");
        }
        in.hocg.zhifou.entity.User user = userOptional.get();
        
        return new User(user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
