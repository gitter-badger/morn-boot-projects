package site.morn.bean;

import site.morn.bean.annotation.Name;

/**
 * 注解标记
 *
 * <p>标记是可重复的，否则请使用名称{@link Name}
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/21
 * @since 1.0
 */
public interface AnnotationTag {

  /**
   * 获取名称标记
   *
   * @return 名称标记
   */
  String[] getTags();
}
