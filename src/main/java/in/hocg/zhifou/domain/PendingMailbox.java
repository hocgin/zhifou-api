package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.domain.contant.PendingMailboxConstant;
import in.hocg.zhifou.support.mybatis.DefaultModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_pending_mailbox")
public class PendingMailbox extends DefaultModel<PendingMailbox> {
    
    /**
     * 随机码
     */
    @TableField("code")
    private String code;
    
    /**
     * 用户
     */
    @TableField("user_id")
    private Long userId;
    
    /**
     * 过期时间
     */
    @TableField("expired_at")
    private LocalDateTime expiredAt;
    
    /**
     * 状态 [禁用, 已使用, 未使用]
     */
    @TableField("status")
    private Integer status = PendingMailboxConstant.STATUS_DISABLED;
    
}
