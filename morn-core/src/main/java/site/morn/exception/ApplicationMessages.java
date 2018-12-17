package site.morn.exception;

import lombok.RequiredArgsConstructor;
import site.morn.translate.Transfer;
import site.morn.translate.Translators;

/**
 * 应用消息构建器
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/10
 */
@RequiredArgsConstructor
public class ApplicationMessages {

  /**
   * 翻译载体
   */
  private final Transfer transfer;

  /**
   * 构建应用消息
   *
   * @param code 消息编码
   * @param args 消息参数
   * @return 应用消息
   */
  public static ApplicationMessage translate(String code, Object... args) {
    return builder().code(code).arguments(args).build();
  }

  /**
   * 获取应用消息构建器
   *
   * @return 应用消息构建器
   */
  private static ApplicationMessages builder() {
    return new ApplicationMessages(Transfer.builder().build());
  }

  /**
   * 设置消息编码
   *
   * @param code 消息编码
   * @return 应用消息构建器
   */
  public ApplicationMessages code(String code) {
    transfer.setCode(code);
    return this;
  }

  /**
   * 设置消息参数
   *
   * @param args 消息参数
   * @return 应用消息构建器
   */
  private ApplicationMessages arguments(Object... args) {
    transfer.setArgs(args);
    return this;
  }

  /**
   * 构建应用消息
   *
   * @return 应用消息
   */
  private ApplicationMessage build() {
    return Translators.defaultTranslator().translate(transfer, ApplicationMessage.class);
  }
}
