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
public class PostDetailResponse {
    private String id;
    private String title;
    private Collection<String> tags;
    private Collection<String> banner;
    private String content;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
    private String classify;
    private UserResponse author;
    private Long liked;
    private boolean isLiked = false;
    private boolean isCollected = false;
    private Long pageviews;
}
