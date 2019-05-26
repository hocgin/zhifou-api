package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Favorite;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.mapper.FavoriteMapper;
import in.hocg.zhifou.pojo.ro.AddFavoriteRo;
import in.hocg.zhifou.pojo.ro.UnFavoriteRo;
import in.hocg.zhifou.service.FavoriteService;
import in.hocg.zhifou.service.PostService;
import in.hocg.zhifou.service.UserService;
import in.hocg.zhifou.util.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.security.Principal;
import java.util.Objects;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite>
        implements FavoriteService {
    private final UserService userService;
    private final PostService postService;
    
    @Override
    public void favorite(Principal principal, AddFavoriteRo param) {
        String username = principal.getName();
        Long postId = param.getPostId();
        User user = userService.findByUsername(username);
        if (Objects.isNull(user)) {
            throw ApiException.newInstance("请先进行登陆");
        }
        
        if (Objects.isNull(postService.getById(postId))) {
            throw ApiException.newInstance("文章不存在");
        }
        
        if (alreadyFavorite(user.getId(), postId)) {
            throw ApiException.newInstance("您已经收藏过了");
        }
    
        Favorite favorite = param.asFavorite();
        favorite.setUserId(user.getId());
        baseMapper.insert(favorite);
    }
    
    @Override
    public void unFavorite(Principal principal, UnFavoriteRo param) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        if (Objects.isNull(user)) {
            throw ApiException.newInstance("请先进行登陆");
        }
    
        Long postId = param.getPostId();
        Long userId = user.getId();
        if (alreadyFavorite(userId, postId)) {
            LambdaQueryWrapper<Favorite> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Favorite::getUserId, userId)
                    .eq(Favorite::getPostId, postId);
            baseMapper.delete(queryWrapper);
        }
    }
    
    
    @Override
    public boolean alreadyFavorite(Long userId, Long postId) {
        Assert.notNull(userId, "参数错误");
        Assert.notNull(postId, "参数错误");
        
        LambdaQueryWrapper<Favorite> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Favorite::getUserId, userId)
                .eq(Favorite::getPostId, postId);
        return baseMapper.selectCount(queryWrapper) > 0;
    }
}
