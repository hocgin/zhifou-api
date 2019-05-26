package in.hocg.zhifou.pojo.ro;

import in.hocg.zhifou.domain.Favorite;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by hocgin on 2019/5/26.
 * email:gin@gmail.com
 *
 * @author hocgin
 */
@Data
@ApiModel("添加收藏")
public class AddFavoriteRo {
    
    public Favorite asFavorite() {
        Favorite favorite = new Favorite();
        favorite.setPostId(postId);
        return favorite;
    }
    
    @ApiModelProperty(value = "文章 ID", required = true)
    @NotNull(message = "请选择要收藏的文章")
    private Long postId;
    
}
