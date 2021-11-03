package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class N0017_LetterCombinations {

  @Test
  public void test1() {
    assertThat(new Solution().letterCombinations("23", ""),
        containsInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
  }

  class Solution {

    public List<String> letterCombinations(String digits) {
      return letterCombinations(digits, "");
    }

    protected String letters(char digit) {
      return switch (digit) {
        case '2' -> "abc";
        case '3' -> "def";
        case '4' -> "ghi";
        case '5' -> "jkl";
        case '6' -> "mno";
        case '7' -> "pqrs";
        case '8' -> "tuv";
        case '9' -> "wxyz";
        default -> throw new IllegalArgumentException();
      };
    }

    public List<String> letterCombinations(String digits, String prefix) {
      List<String> combinations = new ArrayList<>();
      if (digits.length() == 0) {
        if (prefix.length() == 0) {
          return List.of();
        } else {
          return List.of(prefix);
        }
      }
      String letters = letters(digits.charAt(0));
      for (char letter : letters.toCharArray()) {
        combinations.addAll(letterCombinations(digits.substring(1), prefix + letter));
      }
      return combinations;
    }
  }
}

