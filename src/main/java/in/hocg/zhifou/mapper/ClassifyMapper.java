package in.hocg.zhifou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import in.hocg.zhifou.domain.Classify;
import in.hocg.zhifou.pojo.vo.SearchClassifyVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface ClassifyMapper extends BaseMapper<Classify> {
    
    /**
     * 搜索标签
     * @param likeName
     * @return
     */
    List<SearchClassifyVo> search(@Param("name") String likeName);
}
