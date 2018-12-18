package site.morn.rest;

import site.morn.rest.RestMessage.Level;

/**
 * REST构建器工具类
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/17
 */
public class RestBuilders {

  private RestBuilders() {
  }

  /**
   * 获取默认构建器
   *
   * @return 默认构建器
   */
  private static Rests builder() {
    return Rests.builder();
  }

  /**
   * 获取信息构建器
   *
   * <p>success:true, level:info
   *
   * @return 信息构建器
   */
  public static Rests infoBuilder() {
    return builder().success(true).level(Level.INFO);
  }

  /**
   * 获取错误构建器
   *
   * <p>success:true, level:error
   *
   * @return 错误构建器
   */
  public static Rests errorBuilder() {
    return builder().success(false).level(Level.ERROR);
  }

  /**
   * 获取成功消息构建器
   *
   * <p>success:true, level:info, code:rest.success
   *
   * @return 成功消息构建器
   */
  public static Rests successBuilder() {
    String successCode = Rests.properties().getSuccessCode();
    return successBuilder(successCode).transfer(successCode);
  }

  /**
   * 获取成功消息构建器
   *
   * @param code 国际化编号
   * @return 成功消息构建器
   */
  public static Rests successBuilder(String code) {
    return infoBuilder().code(code).transfer(code);
  }

  /**
   * 获取成功消息构建器
   *
   * @param code 国际化编号
   * @param args 国际化参数
   * @return 成功消息构建器
   */
  public static Rests successBuilder(String code, Object... args) {
    return infoBuilder().code(code).transfer(code, args);
  }

  /**
   * 获取成功消息构建器
   *
   * @param data 数据
   * @return 成功消息构建器
   */
  public static Rests successBuilder(Object data) {
    return successBuilder().data(data);
  }

  /**
   * 获取失败消息构建器
   *
   * @return 失败消息构建器
   */
  public static Rests failureBuilder() {
    String failureCode = Rests.properties().getFailureCode();
    return failureBuilder(failureCode);
  }

  /**
   * 获取失败消息构建器
   *
   * @param code 国际化编号
   * @param args 国际化参数
   * @return 失败消息构建器
   */
  public static Rests failureBuilder(String code, Object... args) {
    return errorBuilder().code(code).transfer(code, args);
  }

  /**
   * 构建成功消息
   *
   * @return 成功消息
   */
  public static RestMessage successMessage() {
    return RestBuilders.successBuilder().build();
  }

  /**
   * 构建成功消息
   *
   * @param code 国际化编号
   * @return 成功消息
   */
  public static RestMessage successMessage(String code) {
    return RestBuilders.successBuilder(code).build();
  }

  /**
   * 构建成功消息
   *
   * @param code 国际化编号
   * @param args 国际化参数
   * @return 成功消息
   */
  public static RestMessage successMessage(String code, Object... args) {
    return RestBuilders.successBuilder(code, args).build();
  }


  /**
   * 构建成功消息
   *
   * @return 成功消息
   */
  public static RestMessage successMessage(Object data) {
    return RestBuilders.successBuilder(data).build();
  }


  /**
   * 构建失败消息
   *
   * @return 成功消息
   */
  public static RestMessage failureMessage() {
    return RestBuilders.failureBuilder().build();
  }

  /**
   * 构建失败消息
   *
   * @param code 国际化编号
   * @param args 国际化参数
   * @return 成功消息
   */
  public static RestMessage failureMessage(String code, Object... args) {
    return RestBuilders.failureBuilder(code, args).build();
  }

}
