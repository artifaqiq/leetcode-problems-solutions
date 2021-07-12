import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class N0007_ReverseInteger {

  @Test
  public void test1() {
    assertThat(new Solution().reverse(321), equalTo(123));
    assertThat(new Solution().reverse(-123), equalTo(-321));
    assertThat(new Solution().reverse(1534236469), equalTo(0));
    assertThat(new Solution().reverse(-2147483412), equalTo(-2143847412));
  }

  class Solution {

    public int reverse(int x) {
      int sign = x > 0 ? 1 : -1;
      x = sign * x;
      int result = x % 10;
      for (int remain = x / 10; remain > 0; remain /= 10) {
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (remain % 10) > 7)) {
          return 0;
        }
        if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (remain % 10) < -8)) {
          return 0;
        }
        result = (result * 10) + (remain % 10);
      }
      return sign * result;
    }
  }
}
