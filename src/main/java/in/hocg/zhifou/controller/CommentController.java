package in.hocg.zhifou.controller;

import in.hocg.zhifou.controller.param.CommentParam;
import in.hocg.zhifou.controller.param.CommentResponse;
import in.hocg.zhifou.service.CommentService;
import in.hocg.zhifou.util.ApiException;
import in.hocg.zhifou.util.http.Result;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    @PostMapping
    public ResponseEntity comment(@PathVariable("target") String targetId,
                                  Principal principal,
                                  @Validated @RequestBody CommentParam param) {
        
        boolean hasParamError = Objects.isNull(param)
                || (param.getParentId() == null && param.getRootId() != null)
                || (param.getParentId() != null && param.getRootId() == null);
        
        // parent_id && root_id 只能同时为 null 或 均不为 null
        if (hasParamError) {
            throw new ApiException("错误操作");
        }
        
        commentService.comment(principal, targetId, param);
        return Result.success("评论成功")
                .asResponseEntity();
    }
    
    /**
     * 根评论搜索
     *
     * @param targetId
     * @param pageable
     * @return
     */
    @PostMapping("_search")
    public ResponseEntity searchRootComment(@PathVariable("target") String targetId,
                                            @PageableDefault(value = 8, sort = {"createdAt"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<CommentResponse> result = commentService.queryRootComment(targetId, pageable);
        return Result.success(result)
                .asResponseEntity();
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
    public ResponseEntity searchChildComment(@PathVariable("target") String targetId,
                                             @PathVariable("rootId") Long rootId,
                                             @PageableDefault(value = 5, sort = {"createdAt"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<CommentResponse> result = commentService.queryChildrenComment(targetId, rootId, pageable);
        return Result.success(result)
                .asResponseEntity();
    }
}
