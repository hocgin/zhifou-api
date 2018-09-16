package in.hocg.beta;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hocgin on 2018/9/2.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class Test2 implements Serializable {
    String id;
    String name;
    Test1 test1;
    
    @Data
    public static class Test1 implements Serializable{
        String name = "12";
    }
}
