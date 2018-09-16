package in.hocg.web.support.base.json;

import in.hocg.web.support.base.json.annotation.JSON;

/**
 * Created by hocgin on 2018/9/3.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface JsonSerializer {
    
    /**
     * 拦截器
     * @param json
     */
    void filter(JSON json);
    
    /**
     * json输出
     * @return
     */
    String toJson(Object object);
}
