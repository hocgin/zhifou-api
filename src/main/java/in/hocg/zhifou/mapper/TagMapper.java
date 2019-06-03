package in.hocg.zhifou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import in.hocg.zhifou.domain.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    
    /**
     * 查找关联 文章 的标签
     *
     * @param postId
     * @return
     */
    List<Tag> findByPostId(@Param("post_id") Long postId);
}
