package site.timely.core;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类转换器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/5/31
 * @apiNote P-模板类型, G-业务类型
 * @since 1.0
 */
public interface BeanConverter<P, G> {
    /**
     * 获取业务类型, 即将模板类型转换为业务类型
     *
     * @param prototype 原型 - 模板类型
     * @return 泛型 - 业务类型
     */
    G generic(P prototype);

    /**
     * 获取模板类型, 即将业务类型转换为模板类型
     *
     * @param generic 泛型 - 业务类型
     * @return 原型 - 模板类型
     */
    P prototype(G generic);

    /**
     * 业务类型集合, 即将模板类型转换为业务类型
     *
     * @param inputs 模板类型集合
     * @return 业务类型集合
     */
    default Collection<G> generics(Collection<P> inputs) {
        if (Objects.isNull(inputs))
            return null;
        return genericityStream(inputs).collect(Collectors.toList());
    }

    /**
     * 模板类型集合, 即将业务类型转换为模板类型
     *
     * @param inputs 业务类型集合
     * @return 模板类型集合
     */
    default Collection<P> prototypes(Collection<G> inputs) {
        if (Objects.isNull(inputs))
            return null;
        return prototypeStream(inputs).collect(Collectors.toList());
    }

    /**
     * 模板类型集合, 即将业务类型转换为模板类型
     *
     * @param inputs 业务类型集合
     * @return 模板类型流
     */
    default Stream<G> genericityStream(Collection<P> inputs) {
        if (Objects.isNull(inputs))
            return null;
        return inputs.stream().map((this::generic));
    }

    /**
     * 模板类型集合, 即将业务类型转换为模板类型
     *
     * @param inputs 业务类型集合
     * @return 模板类型流
     */
    default Stream<P> prototypeStream(Collection<G> inputs) {
        if (Objects.isNull(inputs))
            return null;
        return inputs.stream().map((this::prototype));
    }
}
