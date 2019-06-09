package in.hocg.zhifou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import in.hocg.zhifou.domain.PostBrowsingLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by hocgin on 2019/6/9.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface PostBrowsingLogMapper extends BaseMapper<PostBrowsingLog> {
    
    /**
     * 文章是否已经被浏览
     * @param userId
     * @param postId
     * @return
     */
    boolean isBrowsingPost(@Param("user_id") Long userId, @Param("post_id") Long postId);
}
