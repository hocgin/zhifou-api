package in.hocg.zhifou.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Created by hocgin on 2019/5/30.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Accessors(chain = true)
@ApiModel("文章信息")
public class TimelinePostVo {
    
    @ApiModelProperty(value = "文章列表", required = true)
    private List<PostSummaryVo> posts = Collections.emptyList();
    
    @ApiModelProperty(value = "是否有下一页", required = true)
    private boolean hasNextPage = false;
    
    @ApiModelProperty(value = "这一页的时间", required = true)
    private LocalDate date;
    
}
