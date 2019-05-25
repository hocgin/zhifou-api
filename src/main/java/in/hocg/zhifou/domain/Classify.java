package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_classify")
public class Classify extends DefaultModel<Classify> {
    
    /**
     * 类别名称
     */
    @TableField
    private String name;
    
    /**
     * 创建时间
     */
    @TableField
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    
    /**
     * 更新时间
     */
    @TableField
    private LocalDateTime updatedAt;
    
    /**
     * 删除时间
     */
    @TableField
    private LocalDateTime deletedAt;
    
}
