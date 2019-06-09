package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.PostBrowsingLog;
import in.hocg.zhifou.mapper.PostBrowsingLogMapper;
import in.hocg.zhifou.service.PostBrowsingLogService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


/**
 * Created by hocgin on 2019/6/9.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class PostBrowsingLogServiceImpl extends ServiceImpl<PostBrowsingLogMapper, PostBrowsingLog>
        implements PostBrowsingLogService {
    @Override
    public boolean isBrowsingPost(@NonNull Long userId, @NonNull Long postId) {
        return baseMapper.isBrowsingPost(userId, postId);
    }
}
