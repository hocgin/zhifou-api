package in.hocg.zhifou.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import in.hocg.zhifou.support.base.json.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("文章信息")
public class PostDetailVo {
    @ApiModelProperty(value = "ID", required = true)
    private Long id;
    
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    
    @ApiModelProperty(value = "标签")
    private Collection<String> tags;
    
    @ApiModelProperty(value = "轮播图", required = true)
    private Collection<String> banner;
    
    @ApiModelProperty(value = "文章内容", required = true)
    private String content;
    
    @ApiModelProperty(value = "创建时间", required = true)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    
    @ApiModelProperty(value = "更新时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
    
    @ApiModelProperty(value = "类别", required = true)
    private String classify;
    
    @ApiModelProperty(value = "作者", required = true)
    private UserVo author;
    
    @ApiModelProperty(value = "喜欢数量", required = true)
    private Long liked;
    
    @ApiModelProperty(value = "当前用户是否喜欢", required = true)
    private boolean isLiked = false;
    
    @ApiModelProperty(value = "当前用户是否收藏", required = true)
    private boolean isCollected = false;
    
    @ApiModelProperty(value = "点击数", required = true)
    private Long pageviews;
}
