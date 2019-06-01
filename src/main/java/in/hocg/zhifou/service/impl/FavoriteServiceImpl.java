package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Favorite;
import in.hocg.zhifou.domain.Post;
import in.hocg.zhifou.domain.User;
import in.hocg.zhifou.mapper.FavoriteMapper;
import in.hocg.zhifou.pojo.ro.AddFavoriteRo;
import in.hocg.zhifou.pojo.ro.UnFavoriteRo;
import in.hocg.zhifou.service.FavoriteService;
import in.hocg.zhifou.service.PostService;
import in.hocg.zhifou.service.UserService;
import in.hocg.zhifou.util.ApiException;
import in.hocg.zhifou.util.Vid;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@AllArgsConstructor(onConstructor_ = {@Lazy})
public class FavoriteServiceImpl extends ServiceImpl<FavoriteMapper, Favorite>
        implements FavoriteService {
    private final UserService userService;
    private final PostService postService;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void favorite(Principal principal, AddFavoriteRo param) {
        String username = principal.getName();
        String v = param.getV();
        Long id = Vid.decode(v);
        Post post = postService.getById(id);
        if (Objects.isNull(post)) {
            throw ApiException.newInstance("文章不存在");
        }
        
        User user = userService.findByUsername(username);
        if (alreadyFavorite(user.getId(), post.getId())) {
            return;
        }
        
        Favorite favorite = new Favorite();
        favorite.setPostId(post.getId());
        favorite.setUserId(user.getId());
        baseMapper.insert(favorite);
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unFavorite(Principal principal, UnFavoriteRo param) {
        String v = param.getV();
        Long id = Vid.decode(v);
        Post post = postService.getById(id);
        if (Objects.isNull(post)) {
            throw ApiException.newInstance("文章不存在");
        }
        
        String username = principal.getName();
        User user = userService.findByUsername(username);
        Long postId = post.getId();
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
