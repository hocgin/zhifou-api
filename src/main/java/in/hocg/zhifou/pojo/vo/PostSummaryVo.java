package in.hocg.zhifou.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import in.hocg.zhifou.domain.Tag;
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
@ApiModel("文章概要信息")
public class PostSummaryVo {
    @ApiModelProperty(value = "业务ID", required = true)
    private String v;
    
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    
    @ApiModelProperty(value = "文章路径", required = true)
    private String uri;
    
    @ApiModelProperty(value = "标题图", required = true)
    private String thumb;
    
    @ApiModelProperty(value = "标签")
    private Collection<Tag> tags;
    
    @ApiModelProperty(value = "简介", required = true)
    private String summary;
    
    @ApiModelProperty(value = "作者", required = true)
    private UserSummaryVo author;
    
    @ApiModelProperty(value = "喜欢数", required = true)
    private Long liked;
    
    @ApiModelProperty(value = "当前用户是否喜欢", required = true)
    private Boolean isLiked;
    
    @ApiModelProperty(value = "当前用户是否收藏", required = true)
    private Boolean isFavorites = false;
    
    @ApiModelProperty(value = "点击数", required = true)
    private Long pageviews;
    
    @ApiModelProperty(value = "创建时间", required = true)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    
    @ApiModelProperty(value = "更新时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
    
}
