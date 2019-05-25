package in.hocg.zhifou.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import in.hocg.zhifou.support.base.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("轮播图信息")
public class BannerVo {
    
    @ApiModelProperty(value = "展示图片 URL", required = true)
    private String image;
    
    @ApiModelProperty(value = "跳转地址 URL")
    private String url;
    
    @ApiModelProperty(value = "标题")
    private String title;
    
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;
}
