package in.hocg.zhifou.controller.param;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class BannerResponse {
    
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
     * 创建时间
     */
    @JsonFormat
    private LocalDateTime createdAt;
}
