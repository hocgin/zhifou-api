package in.hocg.web.pojo.domain.enums;

import com.baomidou.mybatisplus.enums.IEnum;

import java.io.Serializable;

/**
 * @author hocgin
 */
public enum ExampleType implements IEnum {
  /**
   * 栗子
   */
  AliPay,
  /**
   * 栗子
   */
  WeiXin;

  @Override
  public Serializable getValue() {
    return this.name();
  }
}
