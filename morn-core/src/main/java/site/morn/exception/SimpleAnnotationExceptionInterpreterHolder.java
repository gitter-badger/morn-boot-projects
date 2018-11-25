package site.morn.exception;

import lombok.Setter;

/**
 * 注解异常解释器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/23
 * @since 1.0
 */
@Setter
public class SimpleAnnotationExceptionInterpreterHolder implements
    AnnotationExceptionInterpreterHolder {

  /**
   * 标签
   */
  private String[] tags;

  /**
   * 类型
   */
  private Class<?>[] targets;

  /**
   * 异常解释器
   */
  private ExceptionInterpreter resolver;

  @Override
  public String[] getTags() {
    return tags;
  }

  @Override
  public ExceptionInterpreter getExceptionInterpreter() {
    return resolver;
  }
}
