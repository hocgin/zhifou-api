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
@Table(name = "t_banner")
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 展示图片
     */
    @Column(nullable = false)
    private String image;
    
    /**
     * 跳转路径
     */
    @Column
    private String url;
    
    /**
     * 标题
     */
    @Column
    private String title;
    
    /**
     * 状态
     * 0 关闭, 1 开启
     */
    private Integer status;
    
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
