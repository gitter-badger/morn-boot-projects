package site.timely.rest;

import site.timely.rest.convert.RestConvertHolder;
import site.timely.rest.convert.RestConverter;
import site.timely.translate.Transfer;
import site.timely.translate.Transfers;
import site.timely.translate.TranslateHolder;
import site.timely.translate.Translator;

import java.util.Objects;

/**
 * REST工具类
 *
 * @author timely-rain
 * @version 1.0.0, 2018/7/25
 * @since 1.0
 */
public class Rests {

    public static final String OK = "morn.rest.ok";
    public static final String ERROR = "morn.rest.error";

    private RestMessage entity;
    private RestConverter converter;
    private Translator translator;
    private Transfer transfer;

    private Rests() {
    }

    /**
     * 设置REST消息体
     *
     * @return REST消息体
     */
    public Rests entity(RestMessage entity) {
        this.entity = entity;
        return this;
    }

    /**
     * 设置翻译器
     *
     * @return REST工具类
     */
    public Rests translator(String name) {
        this.translator = TranslateHolder.translator(name);
        return this;
    }

    /**
     * 设置翻译器
     *
     * @return REST工具类
     */
    public Rests translator(Translator translator) {
        this.translator = translator;
        return this;
    }

    /**
     * 设置转换器
     *
     * @return REST工具类
     */
    public Rests converter(String name) {
        this.converter = RestConvertHolder.getConverter(name);
        return this;
    }

    /**
     * 设置转换器
     *
     * @return REST工具类
     */
    public Rests converter(RestConverter converter) {
        this.converter = converter;
        return this;
    }

    public Rests translate(String code, Object... args) {
        this.transfer = Transfers.transfer(code, args);
        return this.code(code).message(transfer.getMessage());
    }

    public Rests success(boolean value) {
        entity.success(value);
        return this;
    }

    public Rests code(String value) {
        entity.code(value);
        return this;
    }

    public Rests level(RestMessage.Level level) {
        entity.level(level);
        return this;
    }

    public Rests message(String value) {
        entity.message(value);
        return this;
    }

    public Rests data(Object value) {
        entity.data(value);
        return this;
    }

    public RestMessage generate() {
        if (Objects.isNull(translator))
            translator = TranslateHolder.defaultTranslator();
        String message = translator.translate(transfer.getMessage(), transfer.getArgs());
        return entity.message(message);
    }

    @SuppressWarnings("unchecked")
    public <T> T convert() {
        RestMessage restMessage = generate();
        RestConverter<T> converter = this.converter;
        return converter.generic(restMessage);
    }

    private static Rests build() {
        return new Rests().entity(new SimpleRestMessage());
    }

    public static Rests buildOk() {
        return build().translate(OK).success(true).level(RestMessage.Level.Info);
    }

    public static Rests buildError() {
        return build().translate(ERROR).success(false).level(RestMessage.Level.Error);
    }

    public static Rests buildError(String code, Object... args) {
        return build().translate(code, args).success(false).level(RestMessage.Level.Error);
    }

    public static RestMessage ok() {
        return buildOk().generate();
    }

    public static RestMessage ok(String message) {
        return buildOk().message(message).generate();
    }

    public static RestMessage ok(Object data) {
        return buildOk().data(data).generate();
    }

    public static RestMessage error() {
        return buildError().generate();
    }

    public static RestMessage error(String code, Object... args) {
        return buildError(code, args).generate();
    }
}