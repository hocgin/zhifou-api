package in.hocg.zhifou.service;

import in.hocg.zhifou.pojo.vo.BannerVo;
import in.hocg.zhifou.domain.Banner;
import in.hocg.zhifou.repository.BannerRepository;
import in.hocg.zhifou.support.BaseService;
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
public class BannerServiceImpl extends BaseService<Banner, BannerRepository>
        implements BannerService {
    @Override
    public List<BannerVo> getAll() {
        return repository.findAllByStatus(1).stream().map(banner -> {
            BannerVo result = new BannerVo();
            BeanUtils.copyProperties(banner, result);
            return result;
        }).collect(Collectors.toList());
    }
}
