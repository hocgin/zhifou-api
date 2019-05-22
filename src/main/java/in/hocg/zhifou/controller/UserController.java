package in.hocg.zhifou.controller;

import in.hocg.zhifou.config.security.JwtToken;
import in.hocg.zhifou.controller.param.SignInParam;
import in.hocg.zhifou.controller.param.SignUpParam;
import in.hocg.zhifou.entity.User;
import in.hocg.zhifou.service.UserService;
import in.hocg.zhifou.util.http.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by hocgin on 2018/12/30.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Controller
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping
    public ResponseEntity getUserInfo(Principal principal) {
        User user = userService.getCurrentUserInfo(principal);
        return Result.success(user)
                .asResponseEntity();
    }
    
    /**
     * POST /account/sign-in
     * 登陆
     *
     * @return
     */
    @PostMapping(value = "/sign-in")
    public ResponseEntity signIn(@Validated @RequestBody SignInParam param) {
        JwtToken token = userService.signIn(param);
        return Result.success(token)
                .asResponseEntity();
    }
    
    /**
     * POST /account/sign-up
     * 注册
     *
     * @return
     */
    @PostMapping(value = "/sign-up")
    public ResponseEntity signUp(@Validated @RequestBody SignUpParam param) {
        userService.signUp(param);
        return Result.success()
                .asResponseEntity();
    }
    
    
}
