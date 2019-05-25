package in.hocg.zhifou.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import in.hocg.zhifou.pojo.ro.AddCommentRo;
import in.hocg.zhifou.pojo.vo.CommentVo;
import in.hocg.zhifou.service.CommentService;
import in.hocg.zhifou.support.base.PageQuery;
import in.hocg.zhifou.support.security.NeedLogin;
import in.hocg.zhifou.util.ApiException;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Api(tags = "评价相关接口")
@Slf4j
@RestController
@RequestMapping("/api/v1/{target}/comment")
@AllArgsConstructor
public class CommentController {
    
    private final CommentService commentService;
    
    /**
     * 评论
     *
     * @param targetId
     * @param principal
     * @param param
     * @return
     */
    @NeedLogin
    @PostMapping
    @ApiOperation(value = "评论", notes = "需要登陆")
    public Result<Object> comment(@PathVariable("target") String targetId,
                                  Principal principal,
                                  @Validated @RequestBody AddCommentRo param) {
        
        boolean hasParamError = Objects.isNull(param)
                || (param.getParentId() == null && param.getRootId() != null)
                || (param.getParentId() != null && param.getRootId() == null);
        
        // parent_id && root_id 只能同时为 null 或 均不为 null
        if (hasParamError) {
            throw ApiException.newInstance("错误操作");
        }
        
        commentService.comment(principal, targetId, param);
        return Result.success();
    }
    
    /**
     * 根评论搜索
     *
     * @param targetId
     * @param pageable
     * @return
     */
    @PostMapping("_search")
    @ApiOperation(value = "根评论搜索")
    public Result<IPage<CommentVo>> searchRootComment(@PathVariable("target") String targetId,
                                                      @RequestBody PageQuery<Void> pageable) {
        IPage<CommentVo> result = commentService.queryRootComment(targetId, pageable);
        return Result.success(result);
    }
    
    /**
     * 子评论搜索
     *
     * @param targetId
     * @param rootId
     * @param pageable
     * @return
     */
    @PostMapping("{rootId}/_search")
    @ApiOperation(value = "子评论搜索")
    public Result<IPage<CommentVo>> searchChildComment(@PathVariable("target") String targetId,
                                                       @PathVariable("rootId") Long rootId,
                                                       @RequestBody PageQuery<Void> pageable) {
        Assert.notNull(targetId, "系统错误");
        Assert.notNull(rootId, "系统错误");
    
        IPage<CommentVo> result = commentService.queryChildrenComment(targetId, rootId, pageable);
        return Result.success(result);
    }
}
