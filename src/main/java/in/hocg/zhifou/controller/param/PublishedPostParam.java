package in.hocg.zhifou.controller.param;

import in.hocg.zhifou.entity.Post;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class PublishedPostParam {
    
    /**
     * 标题图
     */
    private String banner;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * HTML 文本
     */
    private String content;
    
    /**
     * 标签
     */
    private String tags;
    
    /**
     * 类别
     */
    private Long classifyId;
    
    public Post asPost() {
        Post result = new Post();
        BeanUtils.copyProperties(this, result);
        return result;
    }
}
