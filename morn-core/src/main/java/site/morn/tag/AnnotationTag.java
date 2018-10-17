package site.morn.tag;

/**
 * 注解标记
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

  /**
   * 获取类型标记
   *
   * @return 类型标记
   */
  Class<?>[] getTargets();
}
