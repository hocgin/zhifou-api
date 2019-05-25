package in.hocg.zhifou.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import in.hocg.zhifou.support.security.NeedLogin;
import in.hocg.zhifou.pojo.ro.PublishedPostRo;
import in.hocg.zhifou.pojo.vo.PostDetailVo;
import in.hocg.zhifou.pojo.vo.SearchPostVo;
import in.hocg.zhifou.service.PostService;
import in.hocg.zhifou.support.base.PageQuery;
import in.hocg.zhifou.util.http.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
public class PostController {
    
    private final PostService service;
    
    
    /**
     * 发布
     *
     * @param param
     * @return
     */
    @NeedLogin
    @PostMapping
    public ResponseEntity published(@Validated @RequestBody PublishedPostRo param,
                                    Principal principal) {
        service.published(param, principal);
        return Result.success()
                .asResponseEntity();
    }
    
    /**
     * 检索
     *
     * @param query
     * @return
     */
    @PostMapping("_search")
    public ResponseEntity search(@RequestBody PageQuery<Void> query) {
        Page<SearchPostVo> result = service.search(query);
        return Result.success(result)
                .asResponseEntity();
    }
    
    
    /**
     * 内容
     *
     * @return
     */
    @GetMapping
    public ResponseEntity get(@RequestParam("v") String v) {
        PostDetailVo result = service.getPostDetail(v);
        return Result.success(result)
                .asResponseEntity();
    }
}
