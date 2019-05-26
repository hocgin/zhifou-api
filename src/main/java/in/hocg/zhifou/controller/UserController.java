package in.hocg.zhifou.controller;

import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.pojo.ro.SignInRo;
import in.hocg.zhifou.pojo.ro.SignUpRo;
import in.hocg.zhifou.pojo.vo.TokenVo;
import in.hocg.zhifou.service.UserService;
import in.hocg.zhifou.support.security.NeedLogin;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by hocgin on 2018/12/30.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
@Api(tags = "账号相关接口")
public class UserController {
    
    private final UserService userService;
    
    @NeedLogin
    @GetMapping
    @ApiOperation(value = "获取用户信息", notes = "需要登陆")
    public Result<User> getUserInfo(Principal principal) {
        User user = userService.getCurrentUserInfo(principal);
        return Result.success(user);
    }
    
    @PostMapping(value = "/sign-in")
    @ApiOperation(value = "登陆")
    public Result<TokenVo> signIn(@Validated @RequestBody SignInRo param) {
        TokenVo token = userService.signIn(param);
        return Result.success(token);
    }
    
    @PostMapping(value = "/sign-up")
    @ApiOperation(value = "注册")
    public Result<Object> signUp(@Validated @RequestBody SignUpRo param) {
        userService.signUp(param);
        return Result.success();
    }
    
    
}
