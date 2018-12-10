package site.morn.bean;

/**
 * 实例缓存工具类
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/10
 */
public class BeanCaches {

  /**
   * 默认实例缓存
   */
  private static IdentifiedBeanCache defaultBeanCache;

  private BeanCaches() {
  }

  /**
   * 初始化实例缓存
   *
   * @param beanCache 实例缓存
   */
  public static void initialize(IdentifiedBeanCache beanCache) {
    BeanCaches.defaultBeanCache = beanCache;
  }

  /**
   * 获取默认实例缓存
   *
   * @return 默认实例缓存
   */
  public static IdentifiedBeanCache defaultBeanCache() {
    return defaultBeanCache;
  }
}
