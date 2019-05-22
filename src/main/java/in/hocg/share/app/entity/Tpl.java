package in.hocg.share.app.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
@Entity
@Table(name = "t_tpl")
public class Tpl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
