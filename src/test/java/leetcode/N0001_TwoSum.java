package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class N0001_TwoSum {

  @Test
  public void test() {
    assertThat(Arrays.stream(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)).boxed().collect(Collectors.toList()), hasItems(0, 1));
  }

  class Solution {

    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> numberToIndex = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
        Integer secondNumIndex = numberToIndex.get(target - nums[i]);
        if (secondNumIndex != null && secondNumIndex != i) {
          return new int[]{i, secondNumIndex};
        }
        numberToIndex.put(nums[i], i);
      }

      throw new IllegalArgumentException("Problem constraints violated");
    }
  }
}
