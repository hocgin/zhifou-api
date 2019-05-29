package in.hocg.zhifou.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hocgin on 2019/5/29.
 * email: hocgin@gmail.com
 * 暂未开发
 *
 * @author hocgin
 */
@RestController
@RequestMapping("/api/v1/special-column")
@AllArgsConstructor
@Api(tags = "专栏相关接口")
public class SpecialColumnController {
    
    @PostMapping("_paging")
    @ApiOperation(value = "分页获取专栏")
    public Result<IPage<Object>> paging() {
        return Result.success(new Page<>());
    }
}
