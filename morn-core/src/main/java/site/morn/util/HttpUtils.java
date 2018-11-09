package site.morn.util;

/**
 * Http工具类
 *
 * @author timely-rain
 * @since 1.0.0, 2018/10/23
 */
public final class HttpUtils {

  private HttpUtils() {
  }

  /**
   * Http Header
   */
  public final class Header {

    private Header() {
    }

    public static final String CONTENT_TYPE = "Content-Type";
  }


  /**
   * Http ContentType
   */
  public final class ContentType {

    private ContentType() {
    }

    public static final String JSON = "application/json";
  }
}
