package in.hocg.zhifou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import in.hocg.zhifou.domain.Favorite;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface FavoriteMapper extends BaseMapper<Favorite> {
}
