package in.hocg.zhifou.controller;

import com.google.common.collect.Maps;
import in.hocg.zhifou.pojo.ro.SendEmailVerifyCodeRo;
import in.hocg.zhifou.service.IndexService;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

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
    
    @PostMapping("upload")
    @ApiOperation(value = "上传文件")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        String id = indexService.upload(file);
        return Result.success(id);
    }
    
    @GetMapping("configs")
    @ApiOperation(value = "获取基础配置")
    public Result getConfigs() {
        HashMap<String, Object> configs = Maps.newHashMap();
        configs.put("ossServer", "https://daigou-test.oss-cn-beijing.aliyuncs.com");
        return Result.success(configs);
    }
}
