package site.morn.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 应用异常
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/9
 */
@RequiredArgsConstructor
@Getter
@Setter
public class ApplicationExceptin extends RuntimeException {

  /**
   * 异常消息
   */
  private final ApplicationMessage applicationMessage;
}
