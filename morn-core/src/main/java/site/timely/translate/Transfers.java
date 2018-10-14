package site.timely.translate;

/**
 * 翻译载体构建器
 *
 * @author timely-rain
 * @version 1.0.0, 2018/8/14
 * @since 1.0
 */
public class Transfers {

  private static final String MESSAGE_SUFFIX = "message";

  private Transfer transfer;

  private Transfers() {
    this.transfer = new Transfer();
  }

  public static Transfers build() {
    return new Transfers();
  }

  public static Transfer transfer(String code) {
    return build().code(code).generate();
  }

  public static Transfer transfer(String code, Object... args) {
    return build().code(code).args(args).generate();
  }

  public Transfer generate() {
    return transfer;
  }

  public Transfers code(String code) {
    transfer.setCode(code);
    transfer.setMessage(code + "." + MESSAGE_SUFFIX);
    return this;
  }

  public Transfers args(Object... args) {
    transfer.setArgs(args);
    return this;
  }
}
