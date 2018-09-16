package in.hocg.web.pojo.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import in.hocg.web.pojo.domain.enums.ExampleType;
import in.hocg.base.support.scaffold.DeletedModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author hocgin
 */
@Data
@ToString
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("t_examples")
public class Example extends DeletedModel<Example> {
  @TableField(value = "name")
  private String name;
  @TableField(value = "type")
  private ExampleType type;
}
