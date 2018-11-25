package site.morn.bean.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 标记注解
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/19
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Tag {

  /**
   * 获取名称标记
   *
   * @return 名称标记
   */
  String[] tags() default {};

  /**
   * 获取类型标记
   *
   * @return 类型标记
   */
  Class<?>[] targets() default {};
}
