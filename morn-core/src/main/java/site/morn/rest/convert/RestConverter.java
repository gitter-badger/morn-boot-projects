package site.morn.rest.convert;

import site.morn.core.BeanConverter;
import site.morn.rest.RestMessage;

/**
 * REST消息体转换器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/7/25
 * @since 1.0
 */
public interface RestConverter<T> extends BeanConverter<RestMessage, T> {

}
