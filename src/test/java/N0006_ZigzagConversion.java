import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class N0006_ZigzagConversion {

  @Test
  public void test1() {
    assertThat(new Solution().convert("PAYPALISHIRING", 4), equalTo("PINALSIGYAHRPI"));
    assertThat(new Solution().convert("PAYPALISHIRING", 4), equalTo("PINALSIGYAHRPI"));
    assertThat(new Solution().convert("ARTUR", 1), equalTo("ARTUR"));
    assertThat(new Solution().convert("A", 2), equalTo("A"));
  }

  class Solution {

    public String convert(String s, int numRows) {
      if (numRows == 1) {
        return s;
      }

      StringBuilder result = new StringBuilder();
      int cycleLength = 2 * numRows - 2;

      for (int i = 0; i < numRows; i++) {
        for (int j = 0; i + j < s.length(); j += cycleLength) {
          result.append(s.charAt(i + j));
          if (i != 0 && i + 1 != numRows && j + cycleLength - i < s.length()) {
            result.append(s.charAt(j + cycleLength - i));
          }
        }
      }

      return result.toString();
    }
  }
}
