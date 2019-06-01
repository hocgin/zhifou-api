package in.hocg.zhifou.mapping;

import in.hocg.zhifou.domain.Banner;
import in.hocg.zhifou.pojo.vo.BannerVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface BannerMapping {
    
    BannerMapping INSTANCE = Mappers.getMapper(BannerMapping.class);
    
    /**
     * Banner -> BannerVo
     * @param banner
     * @return
     */
    BannerVo toBannerVo(Banner banner);
}
