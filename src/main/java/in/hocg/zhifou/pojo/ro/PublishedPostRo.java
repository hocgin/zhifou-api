package in.hocg.zhifou.pojo.ro;

import in.hocg.zhifou.domain.Post;
import io.swagger.annotations.ApiModelProperty;
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
    
    @ApiModelProperty(value = "标题图", required = true)
    private String banner;
    
    @ApiModelProperty(value = "标题", required = true)
    @NotBlank(message = "请填写标题")
    private String title;
    
    @ApiModelProperty(value = "HTML 文本", required = true)
    @NotBlank(message = "请填写文章")
    private String content;
    
    @ApiModelProperty(value = "标签")
    private String tags;
    
    @NotNull(message = "请选择类别")
    @ApiModelProperty(value = "类别", required = true)
    private Long classifyId;
    
    public Post asPost() {
        Post result = new Post();
        BeanUtils.copyProperties(this, result);
        return result;
    }
}
