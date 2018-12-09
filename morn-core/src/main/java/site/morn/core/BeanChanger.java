package site.morn.core;

/**
 * 实例改变者
 *
 * <p>{@link BeanChanger}是不可以更改，而{@link BeanConverter}是可逆的</p>
 *
 * @param <S> 源类型
 * @param <T> 目标类型
 * @see BeanConverter 实例转换器
 */
public interface BeanChanger<S, T> {

  /**
   * 改变源对象类型
   *
   * @param source 源对象
   * @return 目标对象
   */
  T change(S source);
}
