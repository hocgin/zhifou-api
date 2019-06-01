package in.hocg.zhifou.util;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import lombok.experimental.UtilityClass;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@UtilityClass
public class LangKit {
    
    /**
     * 获取 MD5 值
     *
     * @param bytes
     * @return
     */
    public static HashCode md5(byte[] bytes) {
        return Hashing.md5().newHasher().putBytes(bytes).hash();
    }
}
