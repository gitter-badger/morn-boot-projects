package site.morn.util;

import java.util.Objects;
import lombok.experimental.UtilityClass;

/**
 * 数组工具类
 *
 * @author timely-rain
 * @since 1.0.0, 2018/11/26
 */
@UtilityClass
public final class ArrayUtils {

  /**
   * 判断数组是否为空
   *
   * @param array 数组
   * @return 数组是否为空
   */
  public static boolean isEmpty(Object[] array) {
    return Objects.isNull(array) || array.length == 0;
  }

  /**
   * 合并为数组
   *
   * @param ts 不定项变量
   * @param <T> 变量类型
   * @return 数组
   */
  public static <T> T[] merge(T... ts) {
    return ts;
  }

  /**
   * 任意检索
   *
   * <p>sources为空时，返回true
   * <p>targets为空时，返回false
   * <p>当sources与targets有任意值匹配时，返回true
   *
   * @param sources 检索条件
   * @param targets 检索目标
   * @return 是否检索成功
   */
  public static boolean anySearch(String[] sources, String[] targets) {
    if (isEmpty(sources)) {
      return true;
    }
    if (isEmpty(targets)) {
      return false;
    }
    for (String source : sources) {
      for (String target : targets) {
        if (Objects.equals(source, target)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 获取第一个匹配项
   *
   * @param array 参数数组
   * @param cls 参数类型
   * @param <T> 参数泛型
   * @return 指定参数
   */
  @SuppressWarnings("unchecked")
  public static <T> T first(Object[] array, Class<T> cls) {
    for (Object argument : array) {
      if (Objects.isNull(argument)) {
        continue;
      }
      if (cls.isAssignableFrom(argument.getClass())) {
        return (T) argument;
      }
    }
    return null;
  }
}
