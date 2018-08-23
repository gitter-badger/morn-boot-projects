package site.timely.exception;

import lombok.Setter;

/**
 * site.timely.exception
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/23
 * @since 1.0
 */
@Setter
public class SimpleAnnotationExceptionResolver implements AnnotationExceptionResolver {
    /**
     * 标签
     */
    private String[] tags;

    /**
     * 类型
     */
    private Class<?>[] classes;

    /**
     * 异常解释器
     */
    private ExceptionResolver resolver;

    @Override
    public String[] getTags() {
        return tags;
    }

    @Override
    public Class<?>[] getTargets() {
        return classes;
    }

    @Override
    public Object resolve(Throwable throwable) {
        return resolver.resolve(throwable);
    }
}
