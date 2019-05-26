package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.SuperModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/26.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_favorite")
public class Favorite extends SuperModel<Favorite> {
    
    @TableField("user_id")
    private Long userId;
    
    @TableField("post_id")
    private Long postId;
    
    @TableField("created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
