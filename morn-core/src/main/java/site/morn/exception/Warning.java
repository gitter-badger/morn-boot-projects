package site.morn.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 异常消息
 *
 * @author timely-rain
 * @since 1.0.0, 2018/10/16
 */
@Builder
@Getter
@Setter
@ToString
public class Warning {

  /**
   * 异常码
   */
  private String code;

  /**
   * 异常消息
   */
  private String message;

  /**
   * 异常解决方案
   */
  private String solution;

  /**
   * 创建应用异常
   *
   * @return 应用异常
   */
  public ApplicationExceptin exception() {
    return new ApplicationExceptin(this);
  }

  /**
   * 抛出应用异常
   */
  public void throwing() {
    throw exception();
  }
}
