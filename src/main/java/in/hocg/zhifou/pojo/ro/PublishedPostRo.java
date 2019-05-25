package in.hocg.zhifou.pojo.ro;

import in.hocg.zhifou.domain.Post;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class PublishedPostRo {
    
    /**
     * 标题图
     */
    private String banner;
    
    /**
     * 标题
     */
    @NotBlank(message = "请填写标题")
    private String title;
    
    /**
     * HTML 文本
     */
    @NotBlank(message = "请填写文章")
    private String content;
    
    /**
     * 标签
     */
    private String tags;
    
    /**
     * 类别
     */
    @NotNull(message = "请选择类别")
    private Long classifyId;
    
    public Post asPost() {
        Post result = new Post();
        BeanUtils.copyProperties(this, result);
        return result;
    }
}
