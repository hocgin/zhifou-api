package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import in.hocg.zhifou.domain.PostBrowsingLog;

/**
 * Created by hocgin on 2019/6/9.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface PostBrowsingLogService extends IService<PostBrowsingLog> {
    
    /**
     * 文章是否已经浏览过
     * @param userId
     * @param postId
     * @return
     */
    boolean isBrowsingPost(Long userId, Long postId);
}
