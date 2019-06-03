package in.hocg.zhifou.pojo.ro;

import com.google.common.cache.LoadingCache;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("发布文章")
public class PublishedPostRo {
    
    @ApiModelProperty(value = "标题图 ID", required = true)
    @NotBlank(message = "请设置标题图")
    private String thumb;
    
    @ApiModelProperty(value = "标题", required = true)
    @NotBlank(message = "请填写标题")
    private String title;
    
    @ApiModelProperty(value = "HTML 文本", required = true)
    @NotBlank(message = "请填写文章")
    private String content;
    
    @ApiModelProperty(value = "简介", required = true)
    private String summary;
    
    @ApiModelProperty(value = "标签", required = true)
    @NotNull(message = "请选择标签")
    private List<Long> tags;
    
    @ApiModelProperty(value = "关联网址")
    private List<String> website;
    
    @ApiModelProperty(value = "轮播图")
    private List<String> galleries;
    
    @ApiModelProperty(value = "第一条评论")
    private String firstComment;
    
    @ApiModelProperty(value = "是否定时发布")
    private Boolean isSchedule = Boolean.FALSE;
    
    @ApiModelProperty(value = "定时发布时间")
    private LoadingCache scheduleDatetime;
    
}
