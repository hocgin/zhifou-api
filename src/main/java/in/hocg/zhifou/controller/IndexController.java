package in.hocg.zhifou.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@RestController
@RequestMapping("/api/v1/features")
@AllArgsConstructor
@Api(tags = "功能接口")
public class IndexController {
    
    @PostMapping("verifyCode")
    public void sendVerifyCode() {
    
    }
}
