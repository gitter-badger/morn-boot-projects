package site.morn.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * site.morn.util
 *
 * @author timely-rain
 * @since 1.0.0, 2019/4/21
 */
public class ArrayUtilsTest {

  private Integer[] intArray = {1, 2, 3};

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void isEmpty() {
    boolean isEmpty = ArrayUtils.isEmpty(intArray);
    Assert.assertFalse(isEmpty);
  }

  @Test
  public void merge() {
    Integer[] merge = ArrayUtils.merge(1, 2, 3);
    Assert.assertArrayEquals(intArray, merge);
  }
}