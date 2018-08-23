package site.timely.tag.annotation;

/**
 * 标记注解
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/19
 * @since 1.0
 */
public @interface Tag {
    /**
     * 获取名称标记
     *
     * @return 名称标记
     */
    String[] tags() default {};

    /**
     * 获取类型标记
     *
     * @return 类型标记
     */
    Class<?>[] targets() default {};
}
