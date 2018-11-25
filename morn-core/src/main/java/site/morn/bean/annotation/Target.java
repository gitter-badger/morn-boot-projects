package site.morn.bean.annotation;

/**
 * 目标注解
 *
 * <p>目标是唯一的，通常代表实例可处理的对象类型
 *
 * @author timely-rain
 * @since 1.0.0, 2018/11/25
 */
public @interface Target {

  /**
   * 获取目标
   *
   * @return 目标
   */
  Class<?> getTarget();
}
