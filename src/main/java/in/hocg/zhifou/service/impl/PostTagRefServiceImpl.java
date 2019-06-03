package in.hocg.zhifou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.PostTagRef;
import in.hocg.zhifou.mapper.PostTagRefMapper;
import in.hocg.zhifou.service.PostTagRefService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@RequiredArgsConstructor
public class PostTagRefServiceImpl extends ServiceImpl<PostTagRefMapper, PostTagRef>
        implements PostTagRefService {
}
