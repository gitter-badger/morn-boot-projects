package site.morn.log;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 操作元数据
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/4
 */
@Builder
@Getter
@Setter
public class OperateMeta implements AnnotationOperate {

  /**
   * 操作成功标识
   */
  private boolean success;

  /**
   * 操作模块
   */
  private String module;

  /**
   * 操作名称
   */
  private String name;

  /**
   * 操作参数
   */
  private Object[] arguments;

  /**
   * 例外异常类型
   */
  private Class<? extends Throwable>[] excepts;
}
