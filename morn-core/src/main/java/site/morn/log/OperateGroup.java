package site.morn.log;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 操作组
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/4
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface OperateGroup {

  /**
   * 操作模块
   */
  String value();
}
