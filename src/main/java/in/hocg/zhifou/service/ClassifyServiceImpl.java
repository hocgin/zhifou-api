package in.hocg.zhifou.service;

import in.hocg.zhifou.domain.Classify;
import in.hocg.zhifou.repository.ClassifyRepository;
import in.hocg.zhifou.support.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class ClassifyServiceImpl extends BaseService<Classify, ClassifyRepository>
        implements ClassifyService {
}
