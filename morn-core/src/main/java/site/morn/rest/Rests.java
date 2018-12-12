package site.morn.rest;

import java.util.Objects;
import site.morn.bean.IdentifiedBeanCache;
import site.morn.rest.RestMessage.Level;
import site.morn.rest.convert.RestConverter;
import site.morn.translate.Transfer;
import site.morn.translate.Translator;

/**
 * REST工具类
 *
 * @author timely-rain
 * @since 1.0.0, 2018/7/25
 */
public class Rests {

  /**
   * 成功状态码
   */
  public static final String CODE_OK = "morn.ok";

  /**
   * 错误状态码
   */
  public static final String CODE_ERROR = "morn.error";

  /**
   * 标识实例缓存
   */
  private static IdentifiedBeanCache beanCache;

  /**
   * 翻译器
   */
  private static Translator translator;

  /**
   * 消息体
   */
  private RestMessage entity;

  /**
   * 翻译载体
   */
  private Transfer transfer;

  private Rests() {
  }

  /**
   * 初始化
   *
   * @param beanCache 标识实例缓存
   * @param translator 翻译器
   */
  public static void initialize(IdentifiedBeanCache beanCache, Translator translator) {
    Rests.beanCache = beanCache;
    Rests.translator = translator;
  }

  private static Rests pure() {
    return new Rests().entity(new SimpleRestMessage());
  }

  private static Rests pureOk() {
    return pure().success(true).level(Level.Info);
  }

  private static Rests pureError() {
    return pure().success(false).level(Level.Error);
  }

  public static Rests buildOk() {
    return pureOk().code(CODE_OK).translate(CODE_OK);
  }

  public static Rests buildError() {
    return pureError().code(CODE_ERROR).translate(CODE_ERROR);
  }

  public static Rests buildError(String code, Object... args) {
    return pureError().code(code).translate(code, args);
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

  /**
   * 根据外来消息生成REST消息
   *
   * @param foreign 外来消息
   * @param <T> 外来消息类型
   * @return REST消息
   * @see RestConverter REST消息转换器
   */
  public static <T> RestMessage from(T foreign) {
    RestConverter<T> restConverter = beanCache.bean(RestConverter.class, foreign.getClass());
    if (Objects.isNull(restConverter)) {
      return null;
    }
    return restConverter.revert(foreign);
  }

  /**
   * 根据REST消息生成外来消息
   *
   * @param restMessage REST消息
   * @param foreign 外来消息
   * @param <T> 外来消息类型
   * @return 外来消息
   * @see RestConverter REST消息转换器
   */
  public static <T> T to(RestMessage restMessage, Class<T> foreign) {
    RestConverter<T> restConverter = beanCache.bean(RestConverter.class, foreign);
    if (Objects.isNull(restConverter)) {
      return null;
    }
    return restConverter.convert(restMessage);
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

  public Rests translate(String code, Object... args) {
    this.transfer = Transfer.builder().code(code).args(args).build();
    return this;
  }

  public Rests success(boolean value) {
    entity.success(value);
    return this;
  }

  public Rests code(String value) {
    entity.code(value);
    return this;
  }

  public Rests level(Level level) {
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
    String message = translator.translate(transfer);
    return entity.message(message);
  }

  /**
   * 根据当前REST消息，生成外来消息
   *
   * @param foreign 外来消息类
   * @param <T> 外来消息类型
   * @return 外来消息
   */
  public <T> T to(Class<T> foreign) {
    RestConverter<T> restConverter = beanCache.bean(RestConverter.class, foreign);
    if (Objects.isNull(restConverter)) {
      return null;
    }
    return restConverter.convert(generate());
  }
}
