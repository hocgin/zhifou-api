package in.hocg.share.app.repository;

import in.hocg.share.app.entity.Classify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Repository
public interface ClassifyRepository extends JpaRepository<Classify, Long> {

}
