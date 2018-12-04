package site.morn.bean;

import java.util.Collection;

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
   * 注册实例持有者
   *
   * @param holder 实例持有者
   * @param <T> 检索类型
   */
  <T> void register(IdentifiedBeanHolder<T> holder);

  /**
   * 按标识搜索实例
   *
   * @param identify 标识
   * @param <T> 实例类型
   * @return 实例集合
   */
  <T> Collection<T> search(Class<T> type, AnnotationIdentify identify);

  /**
   * 按名称搜索实例
   *
   * @param name 名称
   * @param <T> 实例类型
   * @return 实例集合
   */
  default <T> Collection<T> searchByName(Class<T> type, String name) {
    BeanIdentify identify = BeanIdentify.builder().name(name).build();
    return search(type, identify);
  }

  /**
   * 按标签搜索实例
   *
   * @param tags 标签
   * @param <T> 实例类型
   * @return 实例集合
   */
  default <T> Collection<T> searchByTags(Class<T> type, String... tags) {
    BeanIdentify identify = BeanIdentify.builder().tags(tags).build();
    return search(type, identify);
  }

  /**
   * 按目标搜索实例
   *
   * @param target 目标
   * @param <T> 实例类型
   * @return 实例集合
   */
  default <T> Collection<T> searchByTarget(Class<T> type, Class<?> target) {
    BeanIdentify identify = BeanIdentify.builder().target(target).build();
    return search(type, identify);
  }
}
