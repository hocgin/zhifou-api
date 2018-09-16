package in.hocg.base.util.http;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by hocgin on 2018/9/4.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public abstract class PageCondition implements Serializable {
    protected int limit = 10;
    protected int page = 1;
}
