package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Gallery;
import in.hocg.zhifou.mapper.GalleryMapper;
import in.hocg.zhifou.service.GalleryService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class GalleryServiceImpl extends ServiceImpl<GalleryMapper, Gallery>
        implements GalleryService {
    @Override
    public List<Gallery> findByPostId(@NotNull Long postId) {
        LambdaQueryWrapper<Gallery> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Gallery::getPostId, postId);
        return baseMapper.selectList(queryWrapper);
    }
}
