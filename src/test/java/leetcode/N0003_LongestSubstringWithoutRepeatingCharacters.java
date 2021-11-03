package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class N0003_LongestSubstringWithoutRepeatingCharacters {

  @Test
  public void test1() {
    assertThat(new Solution().lengthOfLongestSubstring("aabcabcdd"), equalTo(4));
    assertThat(new Solution().lengthOfLongestSubstring("a"), equalTo(1));
    assertThat(new Solution().lengthOfLongestSubstring(""), equalTo(0));
    assertThat(new Solution().lengthOfLongestSubstring("abc"), equalTo(3));
    assertThat(new Solution().lengthOfLongestSubstring("dvdf"), equalTo(3));
    assertThat(new Solution().lengthOfLongestSubstring("pwwkew"), equalTo(3));
  }

  class Solution {

    public int lengthOfLongestSubstring(String s) {
      Integer[] occurrences = new Integer[128];
      int result = 0;
      int left = 0;

      for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        if (occurrences[ch] != null && occurrences[ch] >= left) {
          left = occurrences[ch] + 1;
        }
        occurrences[ch] = right;
        result = Math.max(right - left + 1, result);
      }

      return result;
    }
  }
}
