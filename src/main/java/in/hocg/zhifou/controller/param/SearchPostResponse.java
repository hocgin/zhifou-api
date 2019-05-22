package in.hocg.zhifou.controller.param;

import in.hocg.zhifou.controller.param.lang.UserResponse;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String classify;
    private UserResponse author;
    private Long liked;
    private boolean isLiked;
    private Long pageviews;
    
}
