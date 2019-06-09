package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.SuperModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel("轮播图表")
@TableName("t_banner")
public class Banner extends SuperModel<Banner> {
    
    /**
     * 展示图片
     */
    @TableField("image")
    @ApiModelProperty(value = "展示图片", required = true)
    private String image;
    
    /**
     * 跳转路径
     */
    @TableField("url")
    @ApiModelProperty(value = "跳转路径", required = true)
    private String url;
    
    /**
     * 标题
     */
    @TableField("title")
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    
}
