package site.morn.rest;

import java.util.Objects;
import site.morn.bean.IdentifiedBeanCache;
import site.morn.rest.RestMessage.Level;
import site.morn.rest.convert.RestConverter;
import site.morn.translate.Transfer;
import site.morn.translate.Translator;
import site.morn.translate.Translators;

/**
 * REST构建器
 *
 * @author timely-rain
 * @since 1.0.0, 2018/7/25
 */
public class RestBuilder {

  /**
   * 标识实例缓存
   */
  private static IdentifiedBeanCache beanCache;

  /**
   * 翻译器
   */
  private static Translator translator;

  /**
   * REST配置项
   */
  private static RestProperties restProperties;

  /**
   * 消息体
   */
  private RestMessage restMessage;

  /**
   * 翻译载体
   */
  private Transfer transfer;

  private RestBuilder() {
  }

  /**
   * 初始化
   *
   * @param beanCache 标识实例缓存
   * @param translator 翻译器
   * @param restProperties REST配置项
   */
  public static void initialize(IdentifiedBeanCache beanCache, Translator translator,
      RestProperties restProperties) {
    RestBuilder.beanCache = beanCache;
    RestBuilder.translator = translator;
    RestBuilder.restProperties = restProperties;
  }

  /**
   * 获取REST配置项
   *
   * @return REST配置项
   */
  public static RestProperties properties() {
    return restProperties;
  }

  /**
   * 获取REST构建器
   *
   * @return REST构建器
   */
  public static RestBuilder builder() {
    return new RestBuilder().restMessage(new SimpleRestMessage());
  }

  /**
   * 根据外来消息生成REST消息
   *
   * @param foreign 外来消息
   * @param <T> 外来消息类型
   * @return REST消息
   * @see RestConverter REST消息转换器
   */
  @SuppressWarnings("unchecked")
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
  @SuppressWarnings("unchecked")
  public static <T> T to(RestMessage restMessage, Class<T> foreign) {
    RestConverter<T> restConverter = beanCache.bean(RestConverter.class, foreign);
    if (Objects.isNull(restConverter)) {
      return null;
    }
    return restConverter.convert(restMessage);
  }

  /**
   * 根据当前REST消息，生成外来消息
   *
   * @param foreign 外来消息类
   * @param <T> 外来消息类型
   * @return 外来消息
   */
  @SuppressWarnings("unchecked")
  public <T> T to(Class<T> foreign) {
    RestConverter<T> restConverter = beanCache.bean(RestConverter.class, foreign);
    if (Objects.isNull(restConverter)) {
      return null;
    }
    return restConverter.convert(build());
  }

  /**
   * 翻译REST消息
   *
   * <p>如果显示的指定了消息内容{@link RestBuilder#message(String)}，则不会进行翻译。
   *
   * @return REST构建器
   */
  public RestBuilder translate() {
    if (Objects.isNull(restMessage.getMessage())) {
      String messageCode = Translators.formatCode(restProperties.getPrefix(), transfer.getCode(),
          restProperties.getMessageSuffix());
      String message = translator.translate(messageCode, transfer.getArgs());
      restMessage.setMessage(message);
    }
    return this;
  }

  /**
   * 构建REST消息
   *
   * <p>构建消息时，会进行翻译操作{@link Translator#translate(Transfer)}。
   * 如果显示的指定了消息内容{@link RestBuilder#message(String)}，则不会进行翻译。
   *
   * @return REST消息
   */
  public RestMessage build() {
    translate();
    return restMessage;
  }

  /**
   * 设置REST消息体
   *
   * @return REST构建器
   */
  public RestBuilder restMessage(RestMessage restMessage) {
    this.restMessage = restMessage;
    return this;
  }

  /**
   * 设置国际化载体
   *
   * @param code 国际化编码
   * @param args 国际化参数
   * @return REST构建器
   */
  public RestBuilder transfer(String code, Object... args) {
    this.transfer = Transfer.builder().code(code).args(args).build();
    return this;
  }

  /**
   * 设置成功标识
   *
   * @param value 成功标识
   * @return REST构建器
   */
  public RestBuilder success(boolean value) {
    restMessage.setSuccess(value);
    return this;
  }

  /**
   * 设置消息级别
   *
   * @param level 消息级别
   * @return REST构建器
   */
  public RestBuilder level(Level level) {
    restMessage.setLevel(level);
    return this;
  }

  /**
   * 设置状态码
   *
   * @param value 状态码
   * @return REST构建器
   */
  public RestBuilder code(String value) {
    restMessage.setCode(value);
    return this;
  }

  /**
   * 设置消息内容
   *
   * @param value 消息内容
   * @return REST构建器
   */
  public RestBuilder message(String value) {
    restMessage.setMessage(value);
    return this;
  }

  /**
   * 设置消息数据
   *
   * @param value 消息数据
   * @return REST构建器
   */
  public RestBuilder data(Object value) {
    restMessage.setData(value);
    return this;
  }
}
