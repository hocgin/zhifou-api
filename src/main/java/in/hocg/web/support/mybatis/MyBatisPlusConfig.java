package in.hocg.web.support.mybatis;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author hocgin
 */
@Configuration
@MapperScan("in.hocg.*.mapper*")
public class MyBatisPlusConfig {
  
  /**
   * 分页插件，自动识别数据库类型
   * 多租户，请参考官网【插件扩展】
   * @return
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    return new PaginationInterceptor();
  }

  /**
   * 设置 dev test 环境开启
   * @return
   */
  @Bean
  @Profile({"dev","test"})
  public PerformanceInterceptor performanceInterceptor() {
    return new PerformanceInterceptor();
  }

}
