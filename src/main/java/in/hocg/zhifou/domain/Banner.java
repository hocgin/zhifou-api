package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.domain.contant.BannerConstant;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_banner")
public class Banner extends DefaultModel<Banner> {
    
    /**
     * 展示图片
     */
    @TableField("image")
    private String image;
    
    /**
     * 跳转路径
     */
    @TableField("url")
    private String url;
    
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    
    /**
     * 状态
     * 0 关闭, 1 开启
     */
    @TableField("status")
    private Integer status = BannerConstant.STATUS_DISABLE;
    
}
