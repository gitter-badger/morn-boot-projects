package site.morn.exception;

/**
 * 异常解释器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/19
 * @since 1.0
 */
@FunctionalInterface
public interface ExceptionInterpreter {

  /**
   * 解释异常
   *
   * @param throwable 异常
   */
  ExceptionMessage resolve(Throwable throwable);
}
