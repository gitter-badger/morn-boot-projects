package site.timely.exception;

import site.timely.tag.AnnotationTag;

/**
 * 注解异常解释器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/19
 * @since 1.0
 */
public interface AnnotationExceptionInterpreterHolder extends AnnotationTag {

  /**
   * 获取异常解释器
   *
   * @return 异常解释器
   */
  ExceptionInterpreter getExceptionInterpreter();
}
