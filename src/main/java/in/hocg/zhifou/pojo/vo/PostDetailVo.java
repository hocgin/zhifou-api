package in.hocg.zhifou.pojo.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import in.hocg.zhifou.support.base.LocalDateTimeSerializer;
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
public class PostDetailVo {
    private Long id;
    private String title;
    private Collection<String> tags;
    private Collection<String> banner;
    private String content;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
    private String classify;
    private UserVo author;
    private Long liked;
    private boolean isLiked = false;
    private boolean isCollected = false;
    private Long pageviews;
}
