package site.morn.translate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 翻译载体
 *
 * @author timely-rain
 * @since 1.0.0, 2018/8/14
 */
@Builder
@Getter
@Setter
public class Transfer {

  public static final String MESSAGE_SUFFIX = "message";

  /**
   * 国际化编码
   */
  private String code;

  /**
   * 国际化参数
   */
  private Object[] args;

  /**
   * 获取国际化消息编码
   *
   * @return 国际化消息编码
   */
  public String getMessageCode() {
    return code + "." + MESSAGE_SUFFIX;
  }
}
