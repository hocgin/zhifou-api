package in.hocg.zhifou.support.oss;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AliYunOssServiceImplTest {
    @Autowired
    OssService ossService;
    
    @Test
    public void upload() throws IOException {
        Path path = Paths.get("/Users/hocgin/Library/Containers/com.tencent.xinWeChat/Data/Library/Application Support/com.tencent.xinWeChat/2.0b4.0.9/eca6868258818b3382673b32f61d6837/Message/MessageTemp/4d4d3281d860eaa1f72a2e659f00014e/File/\uD83D\uDE00", "01.jpg");
        String upload = ossService.upload(path.toFile());
        log.debug("文件名: {}", upload);
    }
    
    @Test
    public void isExist() {
        boolean exist = ossService.isExist("df3371aaa96fbb3ccd41e83d4557a758.jpg");
        log.debug("{}", exist);
    }
    
    @Test
    public void delete() {
        ossService.delete("df3371aaa96fbb3ccd41e83d4557a758.jpg");
    }
    
    @Test
    public void fetch() {
        Optional<InputStream> fetch = ossService.get("df3371aaa96fbb3ccd41e83d4557a758.jpg");
        log.debug("{}", fetch.isPresent());
    }
}