package site.morn.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 实例注解标识
 *
 * @author timely-rain
 * @since 1.0.0, 2018/11/25
 */
@Getter
@Setter
@Builder
public class BeanAnnotationIdentify implements AnnotationIdentify {

  /**
   * 名称
   */
  private String name;

  /**
   * 标签
   */
  private String[] tags;

  /**
   * 目标类型
   */
  private Class<?> target;
}
