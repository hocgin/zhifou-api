package in.hocg.zhifou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import in.hocg.zhifou.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    
}
