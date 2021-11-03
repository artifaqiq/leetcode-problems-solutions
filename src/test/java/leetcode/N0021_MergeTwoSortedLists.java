package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class N0021_MergeTwoSortedLists {

  @Test
  public void test() {
    int result = new Solution().strStr("mississippi", "pi");
    assertThat(result, equalTo(9));
  }

  class Solution {

    public int strStr(String haystack, String needle) {
      if ("".equals(needle)) {
        return 0;
      }

      int result = -1;
      int needlePointer = 0;
      for (int i = 0; i < haystack.length(); i++) {
        if (haystack.charAt(i) == needle.charAt(needlePointer)) {
          if (needlePointer == 0) {
            result = i;
          }
          needlePointer++;
          if (needlePointer == needle.length()) {
            return result;
          }
        } else {
          needlePointer = 0;
          if (result != -1) {
            i = result;
          }
          result = -1;
        }
      }

      return -1;
    }
  }


}

