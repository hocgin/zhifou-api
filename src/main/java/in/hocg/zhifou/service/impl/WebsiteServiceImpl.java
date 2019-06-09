package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Website;
import in.hocg.zhifou.mapper.WebsiteMapper;
import in.hocg.zhifou.service.WebsiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class WebsiteServiceImpl extends ServiceImpl<WebsiteMapper, Website>
        implements WebsiteService {
    @Override
    public List<Website> findByPostId(@NotNull Long id) {
        LambdaQueryWrapper<Website> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Website::getPostId, id);
        return baseMapper.selectList(queryWrapper);
    }
}
