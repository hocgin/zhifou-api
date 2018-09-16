package in.hocg.web.pojo.filter;


import lombok.Data;

import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * Created by hocgin on 2018/8/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class IdsFilter implements Serializable {
    @Null(message = "异常值")
    private int[] id;
}
