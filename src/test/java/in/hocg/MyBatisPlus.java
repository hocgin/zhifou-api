package in.hocg;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.validation.constraints.AssertFalse;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisPlus {
  @Autowired
  private DataSourceProperties properties;

  private static String AUTHOR = "hocgin";
  private static String OUTPUT_DIR = "/Users/hocgin/Desktop/Test";
  private static String PACKAGE_NAME = "in.hocg";
  private static List TABLES = Arrays.asList("t_users");


  @Test
  public void generateCode() {
    Assert.assertFalse(StringUtils.isEmpty(AUTHOR));
    Assert.assertFalse(StringUtils.isEmpty(OUTPUT_DIR));
    Assert.assertFalse(StringUtils.isEmpty(PACKAGE_NAME));
    boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
    generateByTables(serviceNameStartWithI, PACKAGE_NAME, (String[]) TABLES.toArray());
  }

  private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {

    GlobalConfig config = new GlobalConfig();
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig.setDbType(DbType.MYSQL)
      .setUrl(properties.getUrl())
      .setUsername(properties.getUsername())
      .setPassword(properties.getPassword())
      .setDriverName(properties.getDriverClassName());
    StrategyConfig strategyConfig = new StrategyConfig();
    strategyConfig
      .setCapitalMode(true)
      .setEntityLombokModel(true)
      .setDbColumnUnderline(true)
      .setNaming(NamingStrategy.underline_to_camel)
      .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
    config.setActiveRecord(false)
      .setAuthor(AUTHOR)
      .setOutputDir(OUTPUT_DIR)
      .setFileOverride(true);
    if (!serviceNameStartWithI) {
      config.setServiceName("%sService");
    }

    new AutoGenerator().setGlobalConfig(config)
      .setDataSource(dataSourceConfig)
      .setStrategy(strategyConfig)
      .setPackageInfo(
        new PackageConfig()
          .setParent(packageName)
          .setController("controller")
          .setEntity("domain")
      ).execute();
  }

  private void generateByTables(String packageName, String... tableNames) {
    generateByTables(true, packageName, tableNames);
  }
}
