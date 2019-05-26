package in.hocg.zhifou.controller;

import in.hocg.zhifou.pojo.ro.SearchClassifyRo;
import in.hocg.zhifou.pojo.vo.SearchClassifyVo;
import in.hocg.zhifou.service.ClassifyService;
import in.hocg.zhifou.support.security.NeedLogin;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Api(tags = "类别相关接口")
@Slf4j
@RestController
@RequestMapping("/api/v1/classify")
@AllArgsConstructor
public class ClassifyController {
    
    private final ClassifyService classifyService;
    
    @PostMapping
    @NeedLogin
    @ApiOperation(value = "获取类别")
    public Result search(@Validated @RequestBody SearchClassifyRo param) {
        List<SearchClassifyVo> result = classifyService.search(param);
        return Result.success(result);
    }
    
}
