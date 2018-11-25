package site.morn.bean;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 实例标识
 *
 * <p>实例标识用于描述实例的唯一标识、标签、用途
 *
 * @author timely-rain
 * @see site.morn.bean.annotation.Name
 * @see site.morn.bean.annotation.Tag
 * @see site.morn.bean.annotation.Target
 * @since 1.0.0, 2018/11/25
 */
@Getter
@Setter
@Builder
public class BeanIdentify implements AnnotationIdentify {

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
