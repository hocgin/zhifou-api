package in.hocg.web.manager.oss;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * Created by hocgin on 2018/9/17.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Service
@ConfigurationProperties(value = "aliyun")
public class AliyunOss implements FileOss {
    
    private String accessKey;
    private String accessKeySecret;
    private String endpoint;
    private String bucket;
    
    @Bean
    public OSSClient ossClient() {
        return new OSSClient(endpoint, accessKey, accessKeySecret);
    }
    
    @Override
    public void putObject(String objectName, InputStream is) {
        ossClient().putObject(bucket, objectName, is);
    }
    
    @Override
    public void putObject(String objectName, File file) {
        ossClient().putObject(bucket, objectName, file);
    }
    
    @Override
    public void putObject(String objectName, String content) {
        ossClient().putObject(bucket, objectName, new ByteArrayInputStream(content.getBytes()));
    }
}
