package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class N0005_LongsetPalindromicString {

  @Test
  public void test1() {
    assertThat(new Solution().longestPalindrome("babad"), equalTo("bab"));
    assertThat(new Solution().longestPalindrome("cbbd"), equalTo("bb"));
    assertThat(new Solution().longestPalindrome("a"), equalTo("a"));
    assertThat(new Solution().longestPalindrome("ac"), equalTo("a"));
    assertThat(new Solution().longestPalindrome("acca"), equalTo("acca"));
  }

  class Solution {

    public String longestPalindrome(String s) {
      String result = "";
      StringBuilder current;
      for (int i = 0; i < s.length(); i++) {
        int l = i - 1, r = i + 1;
        current = new StringBuilder(String.valueOf(s.charAt(i)));
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
          current.insert(0, s.charAt(l));
          current.append(s.charAt(r));
          l--;
          r++;
        }
        if (current.length() > result.length()) {
          result = current.toString();
        }

        if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
          current = new StringBuilder();
          current.append(s.charAt(i));
          current.append(s.charAt(i + 1));
          l = i - 1;
          r = i + 2;
          while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            current.insert(0, s.charAt(l));
            current.append(s.charAt(r));
            l--;
            r++;
          }
          if (current.length() > result.length()) {
            result = current.toString();
          }
        }
      }

      return result;
    }
  }
}
