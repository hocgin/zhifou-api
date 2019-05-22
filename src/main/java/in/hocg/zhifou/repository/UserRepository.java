package in.hocg.zhifou.repository;

import in.hocg.zhifou.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * 获取用户信息
     * @param username
     * @return
     */
    Optional<User> findByUsername(String username);
}
