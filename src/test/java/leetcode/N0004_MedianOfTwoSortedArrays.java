package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class N0004_MedianOfTwoSortedArrays {

  @Test
  public void test1() {
    assertThat(new Solution().findMedianSortedArrays(
        new int[]{1, 3},
        new int[]{1, 2}
        ),
        equalTo(2.0));

    assertThat(new Solution().findMedianSortedArrays(
        new int[]{1, 2},
        new int[]{3, 4}
        ),
        equalTo(2.5));
  }

  class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      return 0f;
    }
  }
}
