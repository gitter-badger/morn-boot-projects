package site.morn.bean;

import java.util.List;

/**
 * 标识的实例缓存
 *
 * <p>缓存已标识的实例对象，提供简洁的检索API
 *
 * @author timely-rain
 * @since 1.0.0, 2018/11/25
 */
public interface IdentifiedBeanCache {

  /**
   * 默认缓存名称
   */
  String DEFAULT_CACHE = "defaultBeanCache";

  /**
   * 存储实例持有者
   *
   * @param holder 实例持有者
   * @param <T> 检索类型
   */
  <T> void cache(IdentifiedBeanHolder<T> holder);

  /**
   * 按标识检索实例
   *
   * @param identify 标识
   * @param <T> 实例类型
   * @return 实例集合
   */
  <T> List<T> beans(Class<T> type, AnnotationIdentify identify);

  /**
   * 按名称检索实例
   *
   * @param name 名称
   * @param <T> 实例类型
   * @return 实例
   */
  default <T> T bean(Class<T> type, String name) {
    BeanIdentify identify = BeanIdentify.builder().name(name).build();
    List<T> beans = beans(type, identify);
    if (beans.isEmpty()) {
      return null;
    }
    return beans.get(0);
  }

  /**
   * 按目标检索实例
   *
   * @param target 目标
   * @param <T> 实例类型
   * @return 实例对象
   */
  default <T> T bean(Class<T> type, Class<?> target) {
    BeanIdentify identify = BeanIdentify.builder().target(target).build();
    List<T> beans = beans(type, identify);
    if (beans.isEmpty()) {
      return null;
    }
    return beans.get(0);
  }

  /**
   * 按标签检索实例
   *
   * @param tags 标签
   * @param <T> 实例类型
   * @return 实例集合
   */
  default <T> List<T> beans(Class<T> type, String... tags) {
    BeanIdentify identify = BeanIdentify.builder().tags(tags).build();
    return beans(type, identify);
  }

  /**
   * 按目标检索实例
   *
   * @param target 目标
   * @param <T> 实例类型
   * @return 实例集合
   */
  default <T> List<T> beans(Class<T> type, Class<?> target) {
    BeanIdentify identify = BeanIdentify.builder().target(target).build();
    return beans(type, identify);
  }
}
