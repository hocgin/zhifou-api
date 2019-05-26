package in.hocg.zhifou.controller;

import in.hocg.zhifou.pojo.ro.SendEmailVerifyCodeRo;
import in.hocg.zhifou.service.IndexService;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private final IndexService indexService;
    
    @PostMapping("verify-code")
    @ApiOperation(value = "发送验证码")
    public Result sendVerifyCode(@Validated @RequestBody SendEmailVerifyCodeRo param) {
        indexService.sendVerifyCode(param);
        return Result.success();
    }
}
