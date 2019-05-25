package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.*;
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
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_post")
public class Post extends DefaultModel<Post> {
    /**
     * 标题图
     */
    @TableField("banner")
    private String banner;
    
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    
    /**
     * HTML 文本
     */
    @TableField("content")
    private String content;
    
    /**
     * 标签
     * eg: xx,xx,xx
     */
    @TableField("tags")
    private String tags;
    
    /**
     * 作者ID
     */
    @TableField("author_id")
    private Long authorId;
    
    /**
     * 类别ID
     */
    @TableField("classify_id")
    private Long classifyId;
    
    /**
     * 点赞数
     */
    @TableField("liked")
    private Long liked = 0L;
    
    /**
     * 是否允许评论
     */
    @TableField("allow_commend")
    private boolean allowCommend = true;
}
