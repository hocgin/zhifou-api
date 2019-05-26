package in.hocg.zhifou.pojo.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("搜索类别")
public class SearchClassifyRo {
    
    @ApiModelProperty(value = "名称", required = true, notes = "可模糊匹配")
    private String name;
}
