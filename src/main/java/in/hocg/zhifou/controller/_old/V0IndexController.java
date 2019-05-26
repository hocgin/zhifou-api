package in.hocg.zhifou.controller._old;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import in.hocg.zhifou.service.impl.O0IndexService;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hocgin on 2019/5/4.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Api(tags = "@废弃 基础接口")
@RestController
@RequestMapping("api")
@AllArgsConstructor
public class V0IndexController {
    private final O0IndexService indexService;
    
    
    @RequestMapping(value = "all", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity all() {
        JSONArray result = indexService.all();
        return Result.success(result).asResponseEntity();
    }
    
    @GetMapping(value = "detail")
    public ResponseEntity detail(@RequestParam("path") String path) {
        JSONObject result = indexService.getDetail(path);
        return Result.success(result).asResponseEntity();
    }
    
    @GetMapping(value = "carousel")
    public ResponseEntity carousel() {
        JSONArray result = indexService.getCarousel();
        return Result.success(result).asResponseEntity();
    }
    
    @GetMapping(value = "recommend")
    public ResponseEntity recommend() {
        JSONObject result = indexService.getRecommend();
        return Result.success(result).asResponseEntity();
    }
    
}
