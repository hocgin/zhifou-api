package in.hocg.share.app.controller.param;

import in.hocg.share.app.controller.param.lang.UserResponse;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String classify;
    private UserResponse author;
    private Long liked;
    private boolean isLiked = false;
    private boolean isCollected = false;
    private Long pageviews;
}
