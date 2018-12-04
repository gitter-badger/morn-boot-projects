package site.morn.log;

import java.util.function.Consumer;

/**
 * 操作日志处理器
 *
 * @author timely-rain
 * @since 1.0.0, 2018/12/4
 */
@FunctionalInterface
public interface OperationProcessor extends Consumer<Operation> {

}
