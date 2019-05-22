package in.hocg.zhifou.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public abstract class BaseService<E, R extends JpaRepository<E, Long>> {
    @Autowired
    protected R repository;
    
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }
}
