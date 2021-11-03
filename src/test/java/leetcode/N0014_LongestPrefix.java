package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class N0014_LongestPrefix {

  @Test
  public void test1() {
    assertThat(new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}), equalTo("fl"));
    assertThat(new Solution().longestCommonPrefix(new String[]{"dog", "repp", "flight"}), equalTo(""));
    assertThat(new Solution().longestCommonPrefix(new String[]{}), equalTo(""));
    assertThat(new Solution().longestCommonPrefix(new String[]{"ab", "a"}), equalTo("a"));
  }

  @Test
  public void test2() {
//    assertThat(new Solution2().longestCommonPrefix(new String[]{"flower", "flow", "flight"}), equalTo("fl"));
//    assertThat(new Solution2().longestCommonPrefix(new String[]{"dog", "repp", "flight"}), equalTo(""));
//    assertThat(new Solution2().longestCommonPrefix(new String[]{}), equalTo(""));
//    assertThat(new Solution2().longestCommonPrefix(new String[]{"ab", "a"}), equalTo("a"));
    assertThat(new Solution2().longestCommonPrefix(new String[]{"aaa", "aa", "aaa"}), equalTo("aa"));
    assertThat(new Solution2().longestCommonPrefix(new String[]{"a", "cac", "bcba", "b", "ca"}), equalTo("aa"));
  }

  class Solution {

    public String longestCommonPrefix(String[] strs) {
      if (strs.length == 0) {
        return "";
      }
      StringBuilder result = new StringBuilder(strs[0]);
      for (int i = 1; i < strs.length; i++) {
        for (int j = 0; j < result.length(); j++) {
          if (j >= strs[i].length()) {
            result.replace(j, result.length(), "");
          } else if (strs[i].charAt(j) != result.charAt(j)) {
            result.replace(j, result.length(), "");
          }
        }
      }

      return result.toString();
    }
  }

  class Solution2 {

    public String longestCommonPrefix(String[] strs) {
      return longestCommonPrefix(strs, 0, strs.length);
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
      if (end - start == 0) {
        return "";
      } else if (end - start == 1) {
        return strs[start];
      } else if (end - start == 2) {
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < Math.min(strs[start].length(), strs[end - 1].length()); i++) {
          if (strs[start].charAt(i) == strs[end - 1].charAt(i)) {
            commonPrefix.append(strs[start].charAt(i));
          } else {
            break;
          }
        }
        return commonPrefix.toString();
      } else {
        String leftResult = longestCommonPrefix(strs, 0, strs.length / 2);
        String rightResult = longestCommonPrefix(strs, strs.length / 2, strs.length);
        return longestCommonPrefix(new String[]{leftResult, rightResult}, 0, 2);
      }
    }
  }
}
