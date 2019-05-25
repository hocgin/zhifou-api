package in.hocg.zhifou.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by hocgin on 2019/5/14.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    
    /**
     * 邮箱验证状态 [未验证, 已验证]
     */
    @Column
    private Integer emailVerify = 0;
}
