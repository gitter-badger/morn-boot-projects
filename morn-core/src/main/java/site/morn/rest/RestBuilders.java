package site.morn.rest;

import site.morn.rest.RestMessage.Level;

/**
 * REST构建器工具类
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/17
 */
public class RestBuilders {

  /**
   * 成功状态码
   */
  private static final String CODE_OK = "rest.ok";

  /**
   * 错误状态码
   */
  private static final String CODE_ERROR = "rest.fail";

  private RestBuilders() {
  }

  private static Rests builder() {
    return Rests.builder();
  }

  public static Rests infoBuilder() {
    return builder().success(true).level(Level.INFO);
  }

  public static Rests errorBuilder() {
    return builder().success(false).level(Level.ERROR);
  }

  public static Rests successBuilder() {
    return infoBuilder().code(CODE_OK).transfer(CODE_OK);
  }

  public static Rests successBuilder(String code, Object... args) {
    return infoBuilder().code(code).transfer(code, args);
  }

  public static Rests failureBuilder() {
    return failureBuilder(CODE_ERROR);
  }

  public static Rests failureBuilder(String code, Object... args) {
    return errorBuilder().code(code).transfer(code, args);
  }

}
