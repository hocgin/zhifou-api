package in.hocg.share.app.service;

import in.hocg.share.app.entity.Classify;

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
