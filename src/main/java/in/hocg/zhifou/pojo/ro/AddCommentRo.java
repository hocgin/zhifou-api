package in.hocg.zhifou.pojo.ro;

import in.hocg.zhifou.domain.Comment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by hocgin on 2019/5/14.
 * email:cgin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("评论")
public class AddCommentRo {
    
    public Comment asComment() {
        Comment entity = new Comment();
        entity.setRootId(rootId);
        entity.setParentId(parentId);
        entity.setContent(content);
        return entity;
    }
    
    @ApiModelProperty(value = "根评论ID", required = true)
    private Long rootId;
    
    @ApiModelProperty(value = "父评论ID", required = true)
    private Long parentId;
    
    @NotEmpty(message = "评论内容不能为空")
    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
    
}
