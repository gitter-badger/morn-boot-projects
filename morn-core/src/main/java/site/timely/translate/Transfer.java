package site.timely.translate;

import lombok.Getter;
import lombok.Setter;

/**
 * 翻译载体
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/14
 * @since 1.0
 */
@Getter
@Setter
public class Transfer {

  public static final String MESSAGE_SUFFIX = "message";

  /**
   * 国际化编码
   */
  private String code;
  /**
   * 国际化消息
   */
  private String message;
  /**
   * 国际化参数
   */
  private Object[] args;
}
