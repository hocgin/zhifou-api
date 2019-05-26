package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    
    @Autowired
    UserMapper userMapper;
    
    @Test
    public void findByUsername() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        User user = userMapper.selectOne(wrapper.eq(User::getUsername, "hocgin"));
        System.out.println(user);
    }
}