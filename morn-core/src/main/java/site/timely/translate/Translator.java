package site.timely.translate;

import java.util.Locale;

/**
 * 翻译器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/14
 * @since 1.0
 */
public interface Translator {

  /**
   * 翻译
   *
   * @param code 国际化编码
   * @param args 国际化参数
   * @return 国际化消息
   */
  String translate(String code, Object... args);

  /**
   * 翻译
   *
   * @param locale 语言
   * @param code 国际化编码
   * @param args 国际化参数
   * @return 国际化消息
   */
  String translate(Locale locale, String code, Object... args);
}
