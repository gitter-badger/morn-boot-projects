package site.morn.util;

import java.util.Objects;

/**
 * 数组工具类
 *
 * @author timely-rain
 * @since 1.0.0, 2018/11/26
 */
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
}
