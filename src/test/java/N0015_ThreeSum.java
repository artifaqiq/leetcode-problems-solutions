import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

public class N0015_ThreeSum {

  @Test
  public void test1() {
    List<List<Integer>> result1 = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    assertThat(result1.get(0), containsInAnyOrder(-1, -1, 2));
    assertThat(result1.get(1), containsInAnyOrder(-1, 0, 1));

    List<List<Integer>> result2 = new Solution().threeSum(new int[]{});
    assertThat(result2.size(), equalTo(0));

    List<List<Integer>> result3 = new Solution().threeSum(new int[]{0});
    assertThat(result3.size(), equalTo(0));
  }
}

class Solution {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    HashMap<Integer, NumbersContainer> missedNumbers = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (missedNumbers.containsKey(nums[j]) && !missedNumbers.get(nums[j]).used) {
          NumbersContainer twoSumComponents = missedNumbers.get(nums[j]);
          result.add(List.of(twoSumComponents.first, twoSumComponents.second, nums[j]));
          twoSumComponents.used = true;
        }
        NumbersContainer numbersContainer = new NumbersContainer();
        numbersContainer.first = nums[i];
        numbersContainer.second = nums[j];
        missedNumbers.put(-nums[i] - nums[j], numbersContainer);
      }
    }

    return result;
  }

  protected static class NumbersContainer {

    public boolean used = false;
    public int first;
    public int second;
  }

}

