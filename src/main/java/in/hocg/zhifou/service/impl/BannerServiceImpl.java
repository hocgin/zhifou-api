package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Banner;
import in.hocg.zhifou.mapper.BannerMapper;
import in.hocg.zhifou.pojo.vo.BannerVo;
import in.hocg.zhifou.service.BannerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner>
        implements BannerService {
    @Override
    public List<BannerVo> getAll() {
        List<Banner> result = baseMapper.selectList(lambdaQuery().eq(Banner::getStatus, 1));
        return result.stream().map(banner -> {
            BannerVo entity = new BannerVo();
            BeanUtils.copyProperties(banner, entity);
            return entity;
        }).collect(Collectors.toList());
    }
}
