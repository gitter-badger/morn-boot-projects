package site.morn.exception;

import lombok.RequiredArgsConstructor;
import site.morn.bean.annotation.Target;
import site.morn.translate.Transfer;
import site.morn.translate.TranslateChanger;
import site.morn.translate.Translator;
import site.morn.translate.Translators;

/**
 * 默认异常消息转换器
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/10
 */
@RequiredArgsConstructor
@Target(Warning.class)
public class DefaultExceptionChanger implements TranslateChanger<Warning> {

  /**
   * 警告前缀
   */
  private static final String PREFIX = "error";

  /**
   * 消息后缀
   */
  private static final String MESSAGE_SUFFIX = "message";

  /**
   * 解决方案后缀
   */
  private static final String SOLUTION_SUFFIX = "solution";

  /**
   * 翻译器
   */
  private final Translator translator;

  @Override
  public Warning change(Transfer transfer) {
    String code = transfer.getCode();
    // 格式化国际编码
    String messageCode = Translators.formatCode(PREFIX, code, MESSAGE_SUFFIX);
    String solutionCode = Translators.formatCode(PREFIX, code, SOLUTION_SUFFIX);
    // 翻译
    String message = translator.translate(messageCode, transfer.getArgs());
    String solution = translator.translate(solutionCode, transfer.getArgs());
    // 构建异常消息
    return Warning.builder().code(code).message(message).solution(solution).build();
  }
}
