package in.hocg.zhifou.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by hocgin on 2018/10/21.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ToString
@AllArgsConstructor
@ApiModel("Token 实体")
public class TokenVo {
    
    @ApiModelProperty(value = "token 内容", required = true)
    private String token;
    
}
