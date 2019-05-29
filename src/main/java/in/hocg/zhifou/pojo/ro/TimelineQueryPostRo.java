package in.hocg.zhifou.pojo.ro;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by hocgin on 2019/5/29.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class TimelineQueryPostRo {
    @NotNull(message = "参数错误")
    private Integer cursor = 0;
}
