package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Banner;
import in.hocg.zhifou.mapper.BannerMapper;
import in.hocg.zhifou.mapping.BannerMapping;
import in.hocg.zhifou.pojo.vo.BannerVo;
import in.hocg.zhifou.service.BannerService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner>
        implements BannerService {
    @Override
    public List<BannerVo> getAll() {
        LambdaQueryWrapper<Banner> queryWrapper = new LambdaQueryWrapper<>();
        List<Banner> result = baseMapper.selectList(queryWrapper);
        return result.stream()
                .map(BannerMapping.INSTANCE::toBannerVo)
                .collect(Collectors.toList());
    }
}
