package in.hocg.zhifou.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.ro.SearchPostRo;
import in.hocg.zhifou.pojo.ro.TimelineQueryPostRo;
import in.hocg.zhifou.pojo.vo.PostDetailVo;
import in.hocg.zhifou.pojo.vo.PostSummaryVo;
import in.hocg.zhifou.pojo.vo.TimelinePostVo;
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
import java.util.List;

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
    public Result<Void> published(Principal principal,
                                  @Validated @RequestBody PublishedPostRo param) {
        service.published(param, principal);
        return Result.success();
    }
    
    @PostMapping("_paging")
    @ApiOperation(value = "分页文章")
    public Result<IPage<PostSummaryVo>> paging(Principal principal,
                                               @RequestBody PageQuery<Void> query) {
        IPage<PostSummaryVo> result = service.paging(principal, query);
        return Result.success(result);
    }
    
    @PostMapping("_timeline2")
    @ApiOperation(value = "按时间线获取文章")
    @Deprecated
    public Result<TimelinePostVo> timeline(Principal principal,
                                           @RequestBody TimelineQueryPostRo query) {
        TimelinePostVo result = service.findPostsByTimeline(principal, query);
        return Result.success(result);
    }
    
    @PostMapping("_timeline")
    @ApiOperation(value = "按时间线获取文章")
    public Result<Page<List<TimelinePostVo>>> timeline2(Principal principal,
                                                        @RequestBody PageQuery<Void> query) {
        Page<List<TimelinePostVo>> result = service.pagingByTimeline(principal, query);
        return Result.success(result);
    }
    
    @PostMapping("_search")
    @ApiOperation(value = "检索文章")
    public Result<List<PostSummaryVo>> search(Principal principal,
                                              @RequestBody SearchPostRo query) {
        List<PostSummaryVo> result = service.search(principal, query);
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
