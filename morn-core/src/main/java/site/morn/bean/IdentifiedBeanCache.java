package site.morn.bean;

import java.util.Collection;

/**
 * 标识的实例缓存
 *
 * <p>缓存已标识的实例对象，提供简洁的检索API
 *
 * @param <T> 实例类型
 * @author timely-rain
 * @since 1.0.0, 2018/11/25
 */
public interface IdentifiedBeanCache<T> {

  /**
   * 按标识搜索实例
   *
   * @param identify 标识
   * @return 实例集合
   */
  Collection<T> searchByIdentify(AnnotationIdentify identify);

  /**
   * 按名称搜索实例
   *
   * @param name 名称
   * @return 实例集合
   */
  default Collection<T> searchByName(String name) {
    BeanIdentify identify = BeanIdentify.builder().name(name).build();
    return searchByIdentify(identify);
  }

  /**
   * 按标签搜索实例
   *
   * @param tags 标签
   * @return 实例集合
   */
  default Collection<T> searchByTags(String... tags) {
    BeanIdentify identify = BeanIdentify.builder().tags(tags).build();
    return searchByIdentify(identify);
  }

  /**
   * 按目标搜索实例
   *
   * @param target 目标
   * @return 实例集合
   */
  default Collection<T> searchByTarget(Class<?> target) {
    BeanIdentify identify = BeanIdentify.builder().target(target).build();
    return searchByIdentify(identify);
  }
}
