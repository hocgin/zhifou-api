package in.hocg.zhifou.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import in.hocg.zhifou.domain.Comment;
import in.hocg.zhifou.support.base.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("评论信息")
public class CommentVo {
    
    public CommentVo(Comment comment) {
        BeanUtils.copyProperties(comment, this);
    }
    
    @ApiModelProperty(value = "ID", required = true)
    private Long id;
    
    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
    
    @ApiModelProperty(value = "被评论目标", required = true)
    private Long targetId;
    
    @ApiModelProperty(value = "根级评论ID")
    private Long rootId;
    
    @ApiModelProperty(value = "父级评论ID")
    private Long parentId;
    
    @ApiModelProperty(value = "评论者", required = true)
    private UserVo commenter;
    
    @ApiModelProperty(value = "被评论者")
    private UserVo pCommenter;
    
    @ApiModelProperty(value = "子评论条数")
    private Long commentCount;
    
    @ApiModelProperty(value = "评论时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
}
