package in.hocg.zhifou.repository;

import in.hocg.zhifou.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
