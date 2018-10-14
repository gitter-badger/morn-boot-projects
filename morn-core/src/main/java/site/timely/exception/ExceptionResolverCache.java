package site.timely.exception;

import java.util.List;

/**
 * 异常处理器的缓存器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/21
 * @since 1.0
 */
public interface ExceptionResolverCache {
    /**
     * 默认缓存名称
     */
    String DEFAULT_CACHE = "defaultExceptionResolverCache";

    /**
     * 搜索异常处理器
     *
     * @param tag 标签
     * @return 异常处理器
     */
    List<ExceptionResolver> find(String tag);

    /**
     * 搜索异常处理器
     *
     * @param targets 处理类型
     * @return 异常处理器
     */
    List<ExceptionResolver> find(Class<?>... targets);

    /**
     * 缓存异常处理器
     *
     * @param resolver 处理器
     */
    void put(ExceptionResolver resolver);
}
