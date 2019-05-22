package in.hocg.zhifou.controller.param;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import in.hocg.zhifou.controller.param.lang.UserResponse;
import in.hocg.zhifou.support.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class SearchPostResponse {
    private String v;
    private String title;
    private Collection<String> tags;
    private Collection<String> banner;
    private String desc;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
    private String classify;
    private UserResponse author;
    private Long liked;
    private boolean isLiked;
    private Long pageviews;
    
}
