package in.hocg.zhifou.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import in.hocg.zhifou.support.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class BannerVo {
    
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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
}
