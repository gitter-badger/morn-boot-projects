package site.morn.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 异常消息
 *
 * @author timely-rain
 * @since 1.0.0, 2018/10/16
 */
@Builder
@Getter
@Setter
public class ExceptionMessage {

  /**
   * 异常码
   */
  private String code;

  /**
   * 异常消息
   */
  private String message;
}
