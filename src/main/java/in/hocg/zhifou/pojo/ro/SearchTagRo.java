package in.hocg.zhifou.pojo.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("搜索标签")
public class SearchTagRo {
    @ApiModelProperty(value = "关键词", required = true)
    private String keyword;
}
