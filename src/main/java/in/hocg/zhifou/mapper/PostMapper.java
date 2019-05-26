package in.hocg.zhifou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import in.hocg.zhifou.domain.Post;
import in.hocg.zhifou.pojo.vo.SearchPostVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {
    
    /**
     * 关键词搜索
     * @param keyword
     * @return
     */
    List<SearchPostVo> search(String keyword);
}
