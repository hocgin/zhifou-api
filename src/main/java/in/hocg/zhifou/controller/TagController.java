package in.hocg.zhifou.controller;

import in.hocg.zhifou.domain.Tag;
import in.hocg.zhifou.pojo.ro.SearchTagRo;
import in.hocg.zhifou.service.TagService;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hocgin on 2018/12/30.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/tag")
@RequiredArgsConstructor
@Api(tags = "标签相关接口")
public class TagController {
    
    private final TagService tagService;
    
    
    @PostMapping("_search")
    @ApiOperation(value = "检索标签列表")
    public Result<List<Tag>> search(@RequestBody SearchTagRo ro) {
        List<Tag> result = tagService.search(ro);
        return Result.success(result);
    }
}
