package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayDeque;
import org.junit.jupiter.api.Test;

public class N0236_RemoveAllAdjacentDuplicatesInString {

  @Test
  public void test() {
    assertThat(new Solution().removeDuplicates("abbaca"), equalTo("ca"));
    assertThat(new Solution().removeDuplicates("azxxzy"), equalTo("ay"));
    assertThat(new Solution().removeDuplicates("aaaaaaaaa"), equalTo("a"));
  }

  static class Solution {

    public String removeDuplicates(String s) {
      ArrayDeque<Character> stack = new ArrayDeque<>();
      stack.push(s.charAt(0));

      for (int i = 1; i < s.length(); i++) {
        if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
          stack.pop();
        } else {
          stack.push(s.charAt(i));
        }
      }

      StringBuilder result = new StringBuilder();
      stack.descendingIterator().forEachRemaining(result::append);
      return result.toString();
    }
  }
}
