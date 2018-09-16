package in.hocg.web.mapper;

import in.hocg.web.pojo.domain.Example;
import in.hocg.base.support.scaffold.SuperMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author hocgin
 * 栗子
 */
@Repository
public interface ExampleMapper extends SuperMapper<Example> {
  
  /**
   *
   * @param name
   * @return
   */
  Collection<Example> findLike(String name);
  
  /**
   *
   * @param IDs
   * @return
   */
  Collection<Example> findByIDs(@Param("IDs") String... IDs);

}
