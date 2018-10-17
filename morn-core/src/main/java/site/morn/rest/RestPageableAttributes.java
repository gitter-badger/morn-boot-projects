package site.morn.rest;


import site.morn.core.CriteriaAttributes;

/**
 * REST分页参数
 *
 * @author timely-rain
 * @version 1.0.0, 2018/7/10
 * @see CriteriaAttributes 标准属性类
 * @since 1.0
 */
public interface RestPageableAttributes extends CriteriaAttributes {

  /**
   * 默认页数
   */
  int DEFAULT_PAGE = 0;

  /**
   * 默认单页数量
   */
  int DEFAULT_SIZE = 20;

  /**
   * 当前页
   */
  String PAGE = "page";

  /**
   * 单页数量
   */
  String SIZE = "size";

  default int getPage() {
    return getExpect(PAGE, DEFAULT_PAGE);
  }

  default <T extends RestPageableAttributes> T setPage(int page) {
    return set(PAGE, page);
  }

  default int getSize() {
    return getExpect(SIZE, DEFAULT_SIZE);
  }

  default <T extends RestPageableAttributes> T setSize(int size) {
    return set(SIZE, size);
  }
}
