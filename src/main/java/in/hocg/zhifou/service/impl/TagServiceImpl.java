package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Tag;
import in.hocg.zhifou.mapper.TagMapper;
import in.hocg.zhifou.pojo.ro.SearchTagRo;
import in.hocg.zhifou.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
        implements TagService {
    @Override
    public List<Tag> search(SearchTagRo ro) {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        String keyword = ro.getKeyword();
        queryWrapper.like(Objects.nonNull(keyword), Tag::getName, keyword);
        return baseMapper.selectList(queryWrapper);
    }
    
    @Override
    public List<Tag> findByPostId(Long postId) {
        return baseMapper.findByPostId(postId);
    }
}
