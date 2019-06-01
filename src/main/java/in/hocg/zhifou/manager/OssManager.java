package in.hocg.zhifou.manager;

import in.hocg.zhifou.support.oss.OssService;
import in.hocg.zhifou.util.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OssManager {
    private final OssService ossService;
    
    public String upload(File file) {
        try {
            return ossService.upload(file);
        } catch (IOException e) {
            log.error("上传文件失败", e);
            throw ApiException.newInstance("上传文件失败");
        }
    }
}
