package in.hocg.web.controller;

import in.hocg.base.lang.VerifyException;
import in.hocg.base.support.scaffold.BaseController;
import in.hocg.base.util.RequestKit;
import in.hocg.web.pojo.domain.Wxer;
import in.hocg.web.service.WxerService;
import in.hocg.web.support.wx.WxAccessToken;
import in.hocg.web.support.wx.WxManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author hocgin
 * @date 2018/6/12
 * email: hocgin@gmail.com
 */
@Slf4j
@Controller
@RequestMapping
public class IndexController extends BaseController {
    
    private final WxManager wxManager;
    private final WxerService wxerService;
    
    
    
    @Autowired
    public IndexController(WxManager wxManager, WxerService wxerService) {
        this.wxManager = wxManager;
        this.wxerService = wxerService;
    }
    
    @RequestMapping("/worked")
    @ResponseBody
    public ResponseEntity worked() {
        String text = String.format("worked: %s", LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        return ResponseEntity.ok(text);
    }
    
    @RequestMapping("/login")
    @ResponseBody
    public ResponseEntity login(@RequestParam("code") String code,
                                @RequestParam("encryptedData") String encryptedData,
                                @RequestParam("iv") String iv) throws JSONException, VerifyException {
        log.debug("用户code: {}", code);
        WxAccessToken body;
        try {
            body = wxManager.code2accessToken(encryptedData, iv, code);
        } catch (IOException e) {
            throw new UnsupportedOperationException("解析微信用户信息错误");
        }
    
        Wxer wxer = wxerService.findByOpenId(body.getOpenId());
        
        if (Objects.isNull(wxer)) {
            // 用户注册
            wxer = body.asWxer();
            wxer.setCreatedAt(LocalDateTime.now());
            wxer.setSignUpIp(RequestKit.getClientIP());
            wxerService.insert(wxer);
        } else {
            // 用户登陆
            wxer.setLastLoginIp(RequestKit.getClientIP());
            wxer.setUpdatedAt(LocalDateTime.now());
            wxerService.updateById(wxer);
        }
        
        return ResponseEntity.ok(wxer);
    }
    
}
