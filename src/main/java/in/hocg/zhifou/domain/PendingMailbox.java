package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/23.
 * email: hocgin@gmail.com
 * 待认证的用户
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_pending_mailbox")
public class PendingMailbox extends DefaultModel<PendingMailbox> {
    
    /**
     * 随机码
     */
    @TableField
    private String code;
    
    /**
     * 用户
     */
    @TableField
    private Long userId;
    
    /**
     * 过期时间
     */
    @TableField
    private LocalDateTime expiredAt;
    
    /**
     * 状态 [禁用, 已使用, 未使用]
     */
    @TableField
    @Builder.Default
    private Integer status = 0;
    
}
