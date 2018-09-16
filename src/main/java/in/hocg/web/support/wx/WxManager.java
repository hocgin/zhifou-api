package in.hocg.web.support.wx;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.hocg.web.util.AES;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by hocgin on 2018/9/10.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Slf4j
@Service
public class WxManager {
    private final RestTemplate restTemplate;
    private final WxProperty wxProperty;
    private final ObjectMapper objectMapper;
    
    @Autowired
    public WxManager(RestTemplate restTemplate, WxProperty wxProperty, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.wxProperty = wxProperty;
        this.objectMapper = objectMapper;
    }
    
    /**
     * 获取小程序 access_token
     * @return
     */
    public String getAccessToken() {
        String url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", wxProperty.getAppid(), wxProperty.getSecret());
        return restTemplate.getForObject(url, String.class);
    }
    
    /**
     * 登录凭证校验
     * @param code
     * @return
     */
    public String code2accessToken(String code) {
        log.debug(wxProperty.toString());
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                wxProperty.getAppid(), wxProperty.getSecret(), code);
        return restTemplate.getForObject(url, String.class);
    }
    
    
    public WxAccessToken code2accessToken(String encryptedData, String iv, String code) throws JSONException,
            IOException {
        String body = code2accessToken(code);
        String sessionKey = new JSONObject(body).getString("session_key");
        String userInfoString = AES.decrypt(encryptedData, sessionKey, iv);
        return objectMapper.readValue(userInfoString, WxAccessToken.class);
    }
    
}
