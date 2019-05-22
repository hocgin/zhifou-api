package in.hocg.share.app.service;

import in.hocg.share.app.entity.Classify;
import in.hocg.share.app.repository.ClassifyRepository;
import in.hocg.share.app.support.BaseService;
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
