package site.morn.log;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 操作实例
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/4
 */
@Builder
@Getter
@Setter
public class Operation {

  /**
   * 操作成功标识
   */
  private boolean success;

  /**
   * 操作模块
   */
  private String module;

  /**
   * 操作人
   */
  private String operator;

  /**
   * 操作内容
   */
  private String content;

  /**
   * 操作时间
   */
  private Date date;
}
