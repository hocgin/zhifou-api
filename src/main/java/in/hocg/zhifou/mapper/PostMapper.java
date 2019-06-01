package in.hocg.zhifou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import in.hocg.zhifou.domain.Post;
import in.hocg.zhifou.pojo.vo.PostSummaryVo;
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
    List<PostSummaryVo> search(String keyword);
    
    /**
     * 获取某天创建的所有文章
     * @param day
     * @return
     */
    List<Post> findAllByCreatedDay(@Param("day") LocalDate day);
    
    /**
     * 按指定索引下标返回时间
     * @param n
     * @return
     */
    LocalDate findTimelineByCursor(@Param("n") int n);
    
    /**
     * 查询是否有某天之前创建的文章
     *
     * @param day
     * @return
     */
    boolean existsPostByLtCreatedDay(@Param("day") LocalDate day);
}
