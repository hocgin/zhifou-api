package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.Favorite;
import in.hocg.zhifou.pojo.ro.AddFavoriteRo;
import in.hocg.zhifou.pojo.ro.UnFavoriteRo;

import java.security.Principal;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface FavoriteService extends IService<Favorite> {
    
    /**
     * 收藏
     * @param principal
     * @param param
     */
    void favorite(Principal principal, AddFavoriteRo param);
    
    /**
     * 取消收藏
     * @param principal
     * @param param
     */
    void unFavorite(Principal principal, UnFavoriteRo param);
    
    /**
     * 是否已经收藏
     * @param userId
     * @param postId
     * @return
     */
    boolean alreadyFavorite(Long userId, Long postId);
}
