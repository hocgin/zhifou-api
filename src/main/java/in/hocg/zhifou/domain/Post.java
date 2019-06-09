package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 * 文章
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@TableName("t_post")
@ApiModel("文章表")
public class Post extends DefaultModel<Post> {
    
    @TableField("title")
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    
    @TableField("content")
    @ApiModelProperty(value = "正文", required = true)
    private String content;
    
    @TableField("summary")
    @ApiModelProperty(value = "简介", required = true)
    private String summary;
    
    @ApiModelProperty(value = "标题图", required = true)
    @TableField("thumb")
    private String thumb;
    
    @ApiModelProperty(value = "点赞数", required = true)
    @TableField("liked")
    private Long liked = 0L;
    
    @ApiModelProperty(value = "是否允许评论", required = true)
    @TableField("allow_commend")
    private Boolean allowCommend = true;
}
