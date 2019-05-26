package in.hocg.zhifou.util;

import lombok.experimental.UtilityClass;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@UtilityClass
public class CodeUtil {
    
    /**
     * 获取随机6位整数
     *
     * @return
     */
    public static String getRandom6Number() {
        return Integer.toString(((int) ((Math.random() * 9 + 1) * 100000)));
    }
}
