package in.hocg.zhifou.pojo.ro;

import in.hocg.zhifou.domain.Comment;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class AddCommentRo {
    private Long rootId;
    private Long parentId;
    @NotEmpty(message = "评论内容不能为空")
    private String content;
    
    public Comment asComment() {
        Comment entity = new Comment();
        entity.setRootId(rootId);
        entity.setParentId(parentId);
        entity.setContent(content);
        return entity;
    }
}
