package in.hocg.zhifou.support.mybatis;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/25.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public abstract class DefaultModel<T extends Model<?>> extends SupperModel<T> {
    
    /**
     * 创建时间
     */
    @TableField("created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    /**
     * 创建者
     */
    @TableField("creator")
    private Long creator;
    
    /**
     * 更新时间
     */
    @TableField("updated_at")
    private LocalDateTime updatedAt;
    
    /**
     * 更新者
     */
    @TableField(value = "updater", update = "now()", fill = FieldFill.UPDATE)
    private Long updater;
    
    /**
     * 删除时间
     */
    @TableField("deleted_at")
    private LocalDateTime deletedAt;
    
    /**
     * 删除者
     */
    @TableField("deleter")
    private Long deleter;
}
