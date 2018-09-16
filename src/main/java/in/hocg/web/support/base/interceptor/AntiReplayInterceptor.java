package in.hocg.web.support.base.interceptor;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.hocg.base.util.http.Result;
import in.hocg.web.constant.ResultCode;
import in.hocg.web.constant.http.AntiReplayConstant;
import in.hocg.web.support.cache.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author hocgin
 * @date 18-8-20
 * 防重放攻击
 **/
@Slf4j
@Component
public class AntiReplayInterceptor extends SimpleHandlerInterceptor {
    
    private final CacheService cacheService;
    private final ObjectMapper objectMapper;
    
    @Autowired
    public AntiReplayInterceptor(CacheService cacheService, ObjectMapper objectMapper) {
        this.cacheService = cacheService;
        this.objectMapper = objectMapper;
    }
    
    @Override
    public boolean preHandle(ServletWebRequest servletWebRequest,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // GET 请求不处理
        if (servletWebRequest.getHttpMethod() == HttpMethod.GET) {
            return true;
        }
        
        PrintWriter out = response.getWriter();
        
        String sign = Strings.trimToNull(servletWebRequest.getParameter(AntiReplayConstant.ANTI_REPLAY_PARAMETER_SIGN));
        Long timestamp = Long.valueOf(Optional.ofNullable(servletWebRequest.getParameter(AntiReplayConstant.ANTI_REPLAY_PARAMETER_TIMESTAMP)).orElse("0"));
        String nonce = Strings.trimToNull(servletWebRequest.getParameter(AntiReplayConstant.ANTI_REPLAY_PARAMETER_NONCE));
        
        // sign, timestamp, nonce 必填
        if (Objects.isNull(sign)
                || Objects.isNull(nonce)) {
            log.debug(String.format("必填: sign(%s), timestamp(%s), nonce(%s)", sign, timestamp, nonce));
            out.write(wrap(ResultCode.VERIFICATION_FAILED));
            return false;
        }
        
        // 验证timestamp
        long currentTimeMillis = System.currentTimeMillis();
        long startExpiredTimeMillis = currentTimeMillis - AntiReplayConstant.ANTI_REPLAY_INTERVAL;
        long endExpiredTimeMillis = currentTimeMillis + AntiReplayConstant.ANTI_REPLAY_INTERVAL;
        if (timestamp > startExpiredTimeMillis
                && timestamp < endExpiredTimeMillis) {
            log.debug(String.format("时间戳为%d, 检查范围: (%d, %d)", timestamp, startExpiredTimeMillis, endExpiredTimeMillis));
            out.write(wrap(ResultCode.VERIFICATION_FAILED));
            return false;
        }
        
        // 验证 nonce
        String nonceKey = String.format("%s.%s", AntiReplayConstant.ANTI_REPLAY_PARAMETER_NONCE, nonce);
        if (cacheService.contains(nonceKey)) {
            log.debug(String.format("nonce[%s] 请检查nonce参数", nonce));
            out.write(wrap(ResultCode.VERIFICATION_FAILED));
            return false;
        }
        
        // 验证 sign
        Map<String, String[]> parameterMap = servletWebRequest.getParameterMap();
        String[] keys = parameterMap.keySet()
                .toArray(new String[]{});
        
        // 格式: k=v&k=v&k=v, md5(k=v&k=v&k=v)
        Optional<String> str = Arrays.stream(keys)
//                .sorted()
                .filter(AntiReplayConstant.ANTI_REPLAY_PARAMETER_SIGN::equals)
                .map(key -> String.format("%s=%s", key, Arrays.toString(parameterMap.get(key))))
                .reduce((k1, k2) -> String.format("%s&%s", k1, k2));
        String encode = MD5Encoder.encode(str.orElse("").getBytes());
        if (!sign.equals(encode)) {
            log.debug(String.format("请求[%s] != 服务端[%s] 签名错误, 请检查sign字段及加密策略", sign, encode));
            out.write(wrap(ResultCode.VERIFICATION_FAILED));
            return false;
        }
        
        cacheService.set(nonceKey, currentTimeMillis, endExpiredTimeMillis, TimeUnit.MILLISECONDS);
        return true;
    }
    
    
    /**
     * 封装返回对象
     *
     * @param code
     * @return
     * @throws JsonProcessingException
     */
    private String wrap(ResultCode code) throws JsonProcessingException {
        return objectMapper.writeValueAsString(Result.result(code.getCode(), code.getMessage()));
    }
}
