package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.SuperModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@TableName("t_gallery")
@ApiModel("轮播图表")
public class Gallery extends SuperModel<Gallery> {
    
    @TableField("post_id")
    @ApiModelProperty(value = "关联文章 ID", required = true)
    private Long postId;
    
    @TableField("image")
    @ApiModelProperty("图 ID")
    private String image;
    
    @TableField("created_at")
    @ApiModelProperty("创建时间")
    private LocalDateTime createdAt = LocalDateTime.now();
}
