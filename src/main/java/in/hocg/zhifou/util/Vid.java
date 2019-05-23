package in.hocg.zhifou.util;

import org.springframework.util.Base64Utils;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 * 业务编号
 *
 * @author hocgin
 */
public class Vid {
    private final static int START_NUMBER = 1000;
    
    public static String encode(Long id) {
        byte[] bytes = String.valueOf(id + START_NUMBER).getBytes();
        return Base64Utils.encodeToString(bytes).replace("==", "");
    }
    
    public static Long decode(String v) {
        byte[] bytes = Base64Utils.decodeFromString(String.format("%s==", v));
        return Long.valueOf(new String(bytes)) - START_NUMBER;
    }
}
