package in.hocg.zhifou.service.impl;

import in.hocg.zhifou.manager.MailManager;
import in.hocg.zhifou.manager.OssManager;
import in.hocg.zhifou.pojo.ro.SendEmailVerifyCodeRo;
import in.hocg.zhifou.service.IndexService;
import in.hocg.zhifou.util.ApiException;
import in.hocg.zhifou.util.CodeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class IndexServiceImpl implements IndexService {
    
    private final MailManager mailManager;
    private final OssManager ossManager;
    
    @Override
    public void sendVerifyCode(SendEmailVerifyCodeRo param) {
        String code = CodeUtil.getRandom6Number();
        mailManager.sendVerifyCode(code, param.getEmail());
    }
    
    @Override
    public String upload(MultipartFile file) {
        Path tFile;
        try {
            tFile = Files.createTempFile("u", file.getOriginalFilename());
            file.transferTo(tFile);
        } catch (IOException e) {
            log.error("文件上传, 创建临时文件失败", e);
            throw ApiException.newInstance("文件上传失败");
        }
        return ossManager.upload(tFile.toFile());
    }
}
