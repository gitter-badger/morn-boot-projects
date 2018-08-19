package site.timely.translate;

import java.util.Locale;

/**
 * 默认翻译器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/14
 * @since 1.0
 */
public class DefaultTranslator implements Translator {
    static final DefaultTranslator DEFAULT = new DefaultTranslator();

    @Override
    public String translate(String code, Object... args) {
        return code;
    }

    @Override
    public String translate(Locale locale, String code, Object... args) {
        return code;
    }
}
