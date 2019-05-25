package in.hocg.zhifou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import in.hocg.zhifou.domain.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface BannerMapper extends BaseMapper<Banner> {
    
    /**
     * 查询指定状态的 banner
     *
     * @param status
     * @return
     */
    List<Banner> findAllByStatus(Integer status);
}
