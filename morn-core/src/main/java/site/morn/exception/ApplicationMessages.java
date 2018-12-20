package site.morn.exception;

import java.util.Objects;
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
   * 消息内容
   */
  private String message;

  /**
   * 解决方案
   */
  private String solution;

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
   * 设置消息内容
   *
   * @param message 消息内容
   * @return 应用消息构建器
   */
  public ApplicationMessages messages(String message) {
    this.message = message;
    return this;
  }

  /**
   * 设置解决方案
   *
   * @param solution 解决方案
   * @return 应用消息构建器
   */
  public ApplicationMessages solution(String solution) {
    this.solution = solution;
    return this;
  }

  /**
   * 构建应用消息
   *
   * @return 应用消息
   */
  private ApplicationMessage build() {
    if ((Objects.nonNull(message) && !Objects.equals(message, "")) || (Objects.nonNull(solution)
        && !Objects.equals(solution, ""))) {
      // 当设置了message/solution时，直接构建应用消息
      return ApplicationMessage.builder().code(transfer.getCode()).message(message)
          .solution(solution).build();
    }
    // 当未设置message/solution时，通过Translator构建应用消息
    return Translators.defaultTranslator().translate(transfer, ApplicationMessage.class);
  }
}
