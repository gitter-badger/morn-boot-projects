package site.timely.rest.convert;

import java.util.HashMap;
import java.util.Map;

/**
 * REST消息转换持有者
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/14
 * @since 1.0
 */
public class RestConvertHolder {

  private static Map<String, RestConverter> converters = new HashMap<>();

  @SuppressWarnings("unchecked")
  public static <T> RestConverter<T> getConverter(String name) {
    return converters.get(name);
  }
}
