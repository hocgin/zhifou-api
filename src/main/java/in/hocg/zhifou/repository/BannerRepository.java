package in.hocg.zhifou.repository;

import in.hocg.zhifou.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {
    
    /**
     * 查询指定状态的 banner
     * @param status
     * @return
     */
    List<Banner> findAllByStatus(Integer status);
}
