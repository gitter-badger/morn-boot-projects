package site.morn.core;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类转换器
 *
 * @param <S> 源类型
 * @param <T> 目标类型
 * @author timely-rain
 * @since 1.0.0, 2018/5/31
 */
public interface BeanConverter<S, T> {

  /**
   * 获取目标类型, 即将源类型转换为目标类型
   *
   * @param source 源类型
   * @return 目标类型
   */
  T convert(S source);

  /**
   * 获取源类型, 即将目标类型转换为源类型
   *
   * @param target 目标类型
   * @return 源类型
   */
  S revert(T target);

  /**
   * 目标类型集合, 即将源类型转换为目标类型
   *
   * @param sources 源类型集合
   * @return 目标类型集合
   */
  default Collection<T> converts(Collection<S> sources) {
    if (Objects.isNull(sources)) {
      return null;
    }
    return convertStream(sources).collect(Collectors.toList());
  }

  /**
   * 源类型集合, 即将目标类型转换为源类型
   *
   * @param targets 目标类型集合
   * @return 源类型集合
   */
  default Collection<S> reverts(Collection<T> targets) {
    if (Objects.isNull(targets)) {
      return null;
    }
    return revertStream(targets).collect(Collectors.toList());
  }

  /**
   * 源类型集合, 即将目标类型转换为源类型
   *
   * @param sources 目标类型集合
   * @return 源类型流
   */
  default Stream<T> convertStream(Collection<S> sources) {
    if (Objects.isNull(sources)) {
      return null;
    }
    return sources.stream().map((this::convert));
  }

  /**
   * 源类型集合, 即将目标类型转换为源类型
   *
   * @param targets 目标类型集合
   * @return 源类型流
   */
  default Stream<S> revertStream(Collection<T> targets) {
    if (Objects.isNull(targets)) {
      return null;
    }
    return targets.stream().map((this::revert));
  }
}
