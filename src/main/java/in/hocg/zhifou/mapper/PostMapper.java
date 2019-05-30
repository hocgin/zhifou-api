package in.hocg.zhifou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import in.hocg.zhifou.domain.Post;
import in.hocg.zhifou.pojo.vo.SearchPostVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
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
    
    /**
     * 获取某天创建的所有文章
     * @param day
     * @return
     */
    List<Post> findAllByCreatedDay(@Param("day") LocalDate day);
    
    /**
     * 查询是否有某天创建的文章
     *
     * @param day
     * @return
     */
    boolean hasPostByCreatedDay(@Param("day") LocalDate day);
}
