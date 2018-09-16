package in.hocg.base.support.scaffold;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author hocgin
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public abstract class SuperModel<T extends Model> extends Model<T> {
  @TableId(value = "id", type = IdType.AUTO)
  private int id;

  @Override
  protected Serializable pkVal() {
    return this.id;
  }
}
