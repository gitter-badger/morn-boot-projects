package site.morn.rest;

import java.util.List;
import site.morn.bean.IdentifiedBeanCache;
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
  private static final String CODE_OK = "morn.ok";

  /**
   * 错误状态码
   */
  private static final String CODE_ERROR = "morn.error";

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

  private static Rests build() {
    return new Rests().entity(new SimpleRestMessage());
  }

  public static Rests buildOk() {
    return build().translate(CODE_OK).success(true).level(RestMessage.Level.Info);
  }

  public static Rests buildError() {
    return buildError(CODE_ERROR).success(false).level(RestMessage.Level.Error);
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

  /**
   * 根据外来消息生成REST消息
   *
   * @param foreign 外来消息
   * @param <T> 外来消息类型
   * @return REST消息
   * @see RestConverter REST消息转换器
   */
  public static <T> RestMessage from(T foreign) {
    List<RestConverter> restConverters = beanCache
        .beans(RestConverter.class, foreign.getClass());
    if (restConverters.size() == 0) {
      return null;
    }
    RestConverter<T> restConverter = restConverters.get(0);
    return restConverter.prototype(foreign);
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
    List<RestConverter> restConverters = beanCache
        .beans(RestConverter.class, foreign);
    if (restConverters.size() == 0) {
      return null;
    }
    RestConverter<T> restConverter = restConverters.get(0);
    return restConverter.generic(restMessage);
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
    return this.code(code);
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
    String message = translator.translate(transfer.getMessageCode(), transfer.getArgs());
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
    List<RestConverter> restConverters = beanCache
        .beans(RestConverter.class, foreign);
    if (restConverters.size() == 0) {
      return null;
    }
    RestConverter<T> restConverter = restConverters.get(0);
    return restConverter.generic(this.entity);
  }
}
