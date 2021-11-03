package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class N0020_ValidParentheses {

  @Test
  public void test1() {
    assertThat(new Solution().isValid("{[]}"), equalTo(true));
    assertThat(new Solution().isValid("([)]"), equalTo(false));
    assertThat(new Solution().isValid("(]"), equalTo(false));
  }

  class Solution {

    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for (char c : s.toCharArray()) {
        if (stack.empty() || c == '{' || c == '(' || c == '[') {
          stack.push(c);
        } else if ((c == '}' && stack.peek() == '{')
            || (c == ')' && stack.peek() == '(')
            || (c == ']' && stack.peek() == '[')
        ) {
          stack.pop();
        } else {
          stack.push(c);
        }
      }

      return stack.empty();
    }
  }
}

