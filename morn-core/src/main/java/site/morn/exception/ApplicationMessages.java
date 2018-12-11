package site.morn.exception;

import lombok.RequiredArgsConstructor;
import site.morn.translate.Transfer;
import site.morn.translate.Translators;

/**
 * 警告构建器
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
   * 构建警告消息
   *
   * @param code 警告编码
   * @param args 警告参数
   * @return 警告消息
   */
  public static ApplicationMessage translate(String code, Object... args) {
    return builder().code(code).arguments(args).build();
  }

  /**
   * 获取警告构建器
   *
   * @return 警告构建器
   */
  private static ApplicationMessages builder() {
    return new ApplicationMessages(Transfer.builder().build());
  }

  /**
   * 设置警告编码
   *
   * @param code 警告编码
   * @return 警告构建器
   */
  public ApplicationMessages code(String code) {
    transfer.setCode(code);
    return this;
  }

  /**
   * 设置警告参数
   *
   * @param args 警告参数
   * @return 警告构建器
   */
  private ApplicationMessages arguments(Object... args) {
    transfer.setArgs(args);
    return this;
  }

  /**
   * 构建警告消息
   *
   * @return 警告消息
   */
  private ApplicationMessage build() {
    return Translators.defaultTranslator().translate(transfer, ApplicationMessage.class);
  }
}
