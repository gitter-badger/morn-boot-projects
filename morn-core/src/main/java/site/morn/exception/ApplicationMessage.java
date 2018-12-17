package site.morn.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 应用消息
 *
 * @author timely-rain
 * @since 1.0.0, 2018/10/16
 */
@Builder
@Getter
@Setter
@ToString
public class ApplicationMessage {

  /**
   * 状态码
   */
  private String code;

  /**
   * 消息内容
   */
  private String message;

  /**
   * 解决方案
   */
  private String solution;

  /**
   * 创建应用异常
   *
   * @return 应用异常
   */
  public ApplicationException exception() {
    return new ApplicationException(this);
  }

  /**
   * 抛出应用异常
   */
  public void thrown() {
    throw exception();
  }
}
