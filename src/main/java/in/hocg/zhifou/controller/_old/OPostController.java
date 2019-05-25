package in.hocg.zhifou.controller._old;

import in.hocg.zhifou.pojo.ro.AddPostRo;
import in.hocg.zhifou.service.impl.IndexService;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hocgin on 2019/5/4.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Api(tags = "@废弃 旧文章接口")
@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class OPostController {
    private final IndexService indexService;
    
    
    /**
     * 用户投稿
     *
     * @param param
     * @return
     */
    @PostMapping
    public ResponseEntity add(@Validated @RequestBody AddPostRo param) {
        indexService.addPost(param);
        return Result.success()
                .asResponseEntity();
    }
}
