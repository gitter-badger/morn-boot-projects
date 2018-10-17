package site.morn.rest;

import site.morn.core.CriteriaAttributes;

/**
 * REST消息体
 *
 * @author timely-rain
 * @version 1.0.0, 2018/7/25
 * @see CriteriaAttributes 标准属性类
 * @since 1.0
 */
public interface RestMessage extends CriteriaAttributes {

  /**
   * 成功标识
   */
  String SUCCESS = "success";

  /**
   * 错误码
   */
  String CODE = "code";

  /**
   * 消息级别
   *
   * @see Level 级别枚举
   */
  String LEVEL = "level";

  /**
   * 消息
   */
  String MESSAGE = "message";

  /**
   * 数据
   */
  String DATA = "data";

  default <T extends RestMessage> T success(boolean value) {
    return set(SUCCESS, value);
  }

  default boolean success() {
    return getBoolean(SUCCESS);
  }

  default <T extends RestMessage> T code(String value) {
    return set(CODE, value);
  }

  default String code() {
    return getString(CODE);
  }

  default <T extends RestMessage> T level(Level level) {
    return set(LEVEL, level.value);
  }

  default String level() {
    return getString(LEVEL);
  }

  default <T extends RestMessage> T message(String value) {
    return set(MESSAGE, value);
  }

  default String message() {
    return getString(MESSAGE);
  }

  default <T extends RestMessage> T data(Object value) {
    return set(DATA, value);
  }

  default <T> T data() {
    return getExpect(DATA);
  }

  /**
   * 消息级别
   *
   * @author timely-rain
   * @version 1.0.0, 2018/8/6
   * @since 1.0
   */
  enum Level {
    /**
     * 调试
     */
    Debug("debug"),
    /**
     * 信息
     */
    Info("info"),
    /**
     * 警告
     */
    Warning("warning"),
    /**
     * 错误
     */
    Error("error");

    /**
     * 值
     */
    String value;

    Level(String value) {
      this.value = value;
    }
  }
}
