package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class N0011_ConteinerWithMostWater {

  @Test
  public void test1() {
    assertThat(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), equalTo(49));
  }

  class Solution {

    public int maxArea(int[] height) {
      int result = 0;
      int leftPointer = 0, rightPointer = height.length - 1;

      while (leftPointer < rightPointer) {
        if (height[leftPointer] > height[rightPointer]) {
          result = Math.max(result, (rightPointer - leftPointer) * height[rightPointer]);
          rightPointer--;
        } else {
          result = Math.max(result, (rightPointer - leftPointer) * height[leftPointer]);
          leftPointer++;
        }
      }
      return result;
    }
  }
}
