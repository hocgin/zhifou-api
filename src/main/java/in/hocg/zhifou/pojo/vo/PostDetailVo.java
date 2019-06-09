package in.hocg.zhifou.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import in.hocg.zhifou.domain.Tag;
import in.hocg.zhifou.domain.Website;
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
@ApiModel("文章详细信息")
public class PostDetailVo {
    
    @ApiModelProperty(value = "业务ID", required = true)
    private String v;
    
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    
    @ApiModelProperty(value = "文章路径", required = true)
    private String uri;
    
    @ApiModelProperty(value = "标题图", required = true)
    private String thumb;
    
    @ApiModelProperty(value = "关联网址", required = true)
    private Collection<Website> websites;
    
    @ApiModelProperty(value = "标签")
    private Collection<Tag> tags;
    
    @ApiModelProperty(value = "轮播图", required = true)
    private Collection<String> galleries;
    
    @ApiModelProperty(value = "简介", required = true)
    private String summary;
    
    @ApiModelProperty(value = "文章内容", required = true)
    private String content;
    
    @ApiModelProperty(value = "作者", required = true)
    private UserSummaryVo author;
    
    @ApiModelProperty(value = "喜欢数量", required = true)
    private Long likeCount = 0L;
    
    @ApiModelProperty(value = "当前用户是否喜欢", required = true)
    private Boolean isLiked = false;
    
    @ApiModelProperty(value = "当前用户是否已经浏览", required = true)
    private Boolean isBrowsing = false;
    
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
