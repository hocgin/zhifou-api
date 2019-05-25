package in.hocg.zhifou.service;

import in.hocg.zhifou.domain.Classify;

import java.util.Optional;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface ClassifyService {
    Optional<Classify> findById(Long id);
}
