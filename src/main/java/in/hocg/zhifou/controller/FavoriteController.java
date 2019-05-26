package in.hocg.zhifou.controller;

import in.hocg.zhifou.pojo.ro.AddFavoriteRo;
import in.hocg.zhifou.pojo.ro.UnFavoriteRo;
import in.hocg.zhifou.service.FavoriteService;
import in.hocg.zhifou.support.security.NeedLogin;
import in.hocg.zhifou.util.http.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Api(tags = "收藏夹相关接口")
@Slf4j
@RestController
@RequestMapping("/api/v1/favorite")
@AllArgsConstructor
public class FavoriteController {
    
    private final FavoriteService favoriteService;
    
    @PostMapping
    @NeedLogin
    @ApiOperation(value = "收藏")
    public Result favorite(Principal principal,
                           @Validated @RequestBody AddFavoriteRo param) {
        favoriteService.favorite(principal, param);
        return Result.success();
    }
    
    @DeleteMapping
    @NeedLogin
    @ApiOperation(value = "取消收藏")
    public Result unFavorite(Principal principal,
                             @Validated @RequestBody UnFavoriteRo param) {
        favoriteService.unFavorite(principal, param);
        return Result.success();
    }
}
