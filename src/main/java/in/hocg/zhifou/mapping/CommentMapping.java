package in.hocg.zhifou.mapping;

import in.hocg.zhifou.domain.Comment;
import in.hocg.zhifou.pojo.ro.AddCommentRo;
import in.hocg.zhifou.pojo.vo.CommentVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Mapper
public interface CommentMapping {
    
    CommentMapping INSTANCE = Mappers.getMapper(CommentMapping.class);
    
    /**
     * Comment -> CommentVo
     * @param comment
     * @return
     */
    CommentVo toCommentVo(Comment comment);
    
    /**
     * AddCommentRo -> Comment
     *
     * @param comment
     * @return
     */
    Comment fromAddCommentRo(AddCommentRo comment);
}
