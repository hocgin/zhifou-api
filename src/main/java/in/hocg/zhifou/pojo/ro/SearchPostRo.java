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
@ApiModel("搜索文章")
public class SearchPostRo {
    
    @ApiModelProperty(value = "关键词", required = true)
    private String keyword;
}
