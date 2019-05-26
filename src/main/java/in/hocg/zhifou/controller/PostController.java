package in.hocg.zhifou.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.vo.PostDetailVo;
import in.hocg.zhifou.pojo.vo.SearchPostVo;
import in.hocg.zhifou.service.PostService;
import in.hocg.zhifou.support.base.request.PageQuery;
import in.hocg.zhifou.support.security.NeedLogin;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@RestController
@RequestMapping("/api/v1/post")
@AllArgsConstructor
@Api(tags = "文章相关接口")
public class PostController {
    
    private final PostService service;
    
    @NeedLogin
    @PostMapping
    @ApiOperation(value = "发布文章", notes = "需要登陆")
    public Result<Object> published(Principal principal,
                                    @Validated @RequestBody PublishedPostRo param) {
        service.published(param, principal);
        return Result.success();
    }
    
    @PostMapping("_search")
    @ApiOperation(value = "检索文章")
    public Result<IPage<SearchPostVo>> search(Principal principal,
                                              @RequestBody PageQuery<Void> query) {
        IPage<SearchPostVo> result = service.search(principal,
                query);
        return Result.success(result);
    }
    
    @GetMapping
    @ApiOperation(value = "获取文章内容")
    public Result<PostDetailVo> get(Principal principal,
                                    @RequestParam("v") String v) {
        PostDetailVo result = service.getPostDetail(principal, v);
        return Result.success(result);
    }
}
