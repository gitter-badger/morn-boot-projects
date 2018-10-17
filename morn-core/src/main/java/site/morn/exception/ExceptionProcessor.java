package site.morn.exception;

/**
 * 异常处理器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/10/16
 * @since 1.0
 */
public interface ExceptionProcessor {

  /**
   * 处理异常
   *
   * @return 异常消息
   */
  <T extends Exception> ExceptionMessage process(T exception);
}
