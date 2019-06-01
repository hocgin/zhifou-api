package in.hocg.zhifou.support.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Optional;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@RequiredArgsConstructor
public class AliYunOssServiceImpl
        implements OssService {
    private final String buckName;
    private final OSSClient ossClient;
    
    @Override
    public String upload(File file) throws IOException {
        String filename = filename(file);
        ossClient.putObject(buckName, filename, Files.newInputStream(file.toPath()));
        return filename;
    }
    
    @Override
    public boolean isExist(String filename) {
        return ossClient.doesObjectExist(buckName, filename);
    }
    
    @Override
    public void delete(String filename) {
        ossClient.deleteObject(buckName, filename);
    }
    
    @Override
    public Optional<InputStream> get(String filename) {
        if (!isExist(filename)) {
            return Optional.empty();
        }
        OSSObject result = ossClient.getObject(buckName, filename);
        return Optional.of(result.getObjectContent());
    }
}
