package in.hocg.zhifou.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Entity
@Table(name = "t_classify")
public class Classify {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 类别名称
     */
    @Column(nullable = false)
    private String name;
    
    /**
     * 创建时间
     */
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    /**
     * 更新时间
     */
    @Column
    private LocalDateTime updatedAt;
    
    /**
     * 删除时间
     */
    @Column
    private LocalDateTime deletedAt;
    
}
