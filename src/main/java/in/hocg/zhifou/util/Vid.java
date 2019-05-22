package in.hocg.zhifou.util;

import org.springframework.util.Base64Utils;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public class Vid {
    
    public static String encode(Long id) {
        return Base64Utils.encodeToString(String.valueOf(id).getBytes());
    }
    
    public static Long decode(String v) {
        byte[] bytes = Base64Utils.decodeFromString(v);
        return Long.valueOf(new String(bytes));
    }
}
