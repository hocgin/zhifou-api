package in.hocg.jackson;


import in.hocg.web.support.base.json.annotation.JSON;

/**
 * Created by hocgin on 2018/9/3.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface JsonSerializer {
    void filter(JSON json);
    
    void toJson();
}
