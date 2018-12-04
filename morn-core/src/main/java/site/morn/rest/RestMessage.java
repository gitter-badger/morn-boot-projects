package site.morn.rest;

/**
 * REST消息体
 *
 * @author timely-rain
 * @since 1.0.0, 2018/7/25
 */
public interface RestMessage {

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

  /**
   * 成功标识
   */
  <T extends RestMessage> T success(boolean value);

  /**
   * 成功标识
   */
  boolean success();

  /**
   * 状态码
   */
  <T extends RestMessage> T code(String value);

  /**
   * 状态码
   */
  String code();

  /**
   * 消息级别
   *
   * @see Level 级别枚举
   */
  <T extends RestMessage> T level(Level level);

  /**
   * 消息级别
   *
   * @see Level 级别枚举
   */
  String level();

  /**
   * 消息内容
   */
  <T extends RestMessage> T message(String value);

  /**
   * 消息内容
   */
  String message();

  /**
   * 数据
   */
  <T extends RestMessage> T data(Object value);

  /**
   * 数据
   */
  <T> T data();

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
