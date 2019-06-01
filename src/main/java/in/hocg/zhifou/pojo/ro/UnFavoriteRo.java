package in.hocg.zhifou.pojo.ro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("取消收藏")
public class UnFavoriteRo {
    
    @ApiModelProperty(value = "文章业务 ID", required = true)
    @NotNull(message = "请选择要取消收藏的文章")
    private String v;
}
