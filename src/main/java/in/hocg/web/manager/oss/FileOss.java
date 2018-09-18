package in.hocg.web.manager.oss;

import java.io.File;
import java.io.InputStream;

/**
 * Created by hocgin on 2018/9/16.
 * email: hocgin@gmail.com
 * 云存储服务
 *
 * @author hocgin
 */
public interface FileOss {
    
    /**
     * 上传单个文件
     *
     * @param objectName
     * @param is
     */
    void putObject(String objectName, InputStream is);
    
    void putObject(String objectName, File file);
    
    void putObject(String objectName, String content);
    
}
