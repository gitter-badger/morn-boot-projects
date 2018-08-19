package site.timely.translate;

import java.util.HashMap;
import java.util.Map;

/**
 * 翻译持有者
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/14
 * @since 1.0
 */
public class TranslateHolder {
    public static final String DEFAULT = "default";

    private static Map<String, Translator> translators = new HashMap<>();

    static {
        translators.put(DEFAULT, DefaultTranslator.DEFAULT);
    }

    /**
     * 注册翻译器
     *
     * @param name       翻译器名称
     * @param translator 翻译器
     */
    public static void register(String name, Translator translator) {
        translators.put(name, translator);
    }

    /**
     * 默认翻译器
     *
     * @return 翻译器
     */
    public static Translator defaultTranslator() {
        return translators.get(DEFAULT);
    }

    public static Translator translator(String name) {
        return translators.get(name);
    }

    public static String translate(String code, Object... args) {
        return TranslateHolder.defaultTranslator().translate(code, args);
    }
}
