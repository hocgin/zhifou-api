package in.hocg.zhifou.util.lang;

import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.util.Strings;

/**
 * Created by hocgin on 2019/5/23.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@UtilityClass
public class StringKit {
    
    /**
     * 截取部分内容
     *
     * @param content
     * @param length
     * @return
     */
    public static String desc(String content, int length) {
        if (Strings.isBlank(content) || content.length() <= length) {
            return content;
        }
        return content.substring(0, length);
    }
}
