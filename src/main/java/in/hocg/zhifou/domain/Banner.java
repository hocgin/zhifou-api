package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.*;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_banner")
public class Banner extends DefaultModel<Banner> {
    
    /**
     * 展示图片
     */
    private String image;
    
    /**
     * 跳转路径
     */
    private String url;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 状态
     * 0 关闭, 1 开启
     */
    private Integer status;
    
}
