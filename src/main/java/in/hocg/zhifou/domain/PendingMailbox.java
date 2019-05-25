package in.hocg.zhifou.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/23.
 * email: hocgin@gmail.com
 * 待认证的用户
 *
 * @author hocgin
 */
@Data
@Entity
@Table(name = "t_pending_mailbox")
public class PendingMailbox {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 随机码
     */
    @Column(nullable = false)
    private String code;
    
    /**
     * 用户
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    /**
     * 过期时间
     */
    @Column(nullable = false)
    private LocalDateTime expiredAt;
    
    /**
     * 创建时间
     */
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    /**
     * 状态 [禁用, 已使用, 未使用]
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.disable;
    
    enum Status {
        /**
         * 禁用
         */
        disable,
        /**
         * 已使用
         */
        used,
        /**
         * 未使用
         */
        unused
    }
    
}
