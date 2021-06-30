import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.Test;

public class N0002_AddTwoNumbers {

  @Test
  public void test1() {
    ListNode result = new Solution().addTwoNumbers(
        new ListNode(2,
            new ListNode(4,
                new ListNode(3))),
        new ListNode(5,
            new ListNode(6,
                new ListNode(4)))
    );

    assertThat(result.val, equalTo(7));
    assertThat(result.next.val, equalTo(0));
    assertThat(result.next.next.val, equalTo(8));
  }

  @Test
  public void test2() {
    ListNode result = new Solution().addTwoNumbers(
        new ListNode(2,
            new ListNode(4,
                new ListNode(6))),
        new ListNode(5,
            new ListNode(6,
                new ListNode(4)))
    );

    assertThat(result.val, equalTo(7));
    assertThat(result.next.val, equalTo(0));
    assertThat(result.next.next.val, equalTo(1));
    assertThat(result.next.next.next.val, equalTo(1));
    assertThat(result.next.next.next.next, is(nullValue()));
  }

  @Test
  public void test3() {
    ListNode result = new Solution().addTwoNumbers(
        new ListNode(9,
            new ListNode(9,
                new ListNode(9))),
        new ListNode(9,
            new ListNode(9))

    );

    assertThat(result.val, equalTo(8));
    assertThat(result.next.val, equalTo(9));
    assertThat(result.next.next.val, equalTo(0));
    assertThat(result.next.next.next.val, equalTo(1));
    assertThat(result.next.next.next.next, is(nullValue()));
  }


  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      boolean isCarryOver = false;
      ListNode result = new ListNode();
      ListNode currentFirst = l1, currentSecond = l2, currentResult = result;

      while (currentFirst != null || currentSecond != null) {
        int currentSum = (currentFirst == null ? 0 : currentFirst.val)
            + (currentSecond == null ? 0 : currentSecond.val)
            + (isCarryOver ? 1 : 0);

        isCarryOver = false;
        if (currentSum >= 10) {
          isCarryOver = true;
          currentSum = currentSum % 10;
        }

        currentResult.val = currentSum;
        if ((currentFirst != null && currentFirst.next != null) || (currentSecond != null && currentSecond.next != null)) {
          currentResult.next = new ListNode();
          currentResult = currentResult.next;
        }

        currentFirst = currentFirst == null ? currentFirst : currentFirst.next;
        currentSecond = currentSecond == null ? currentSecond : currentSecond.next;
      }
      if (isCarryOver) {
        currentResult.next = new ListNode(1);
      }

      return result;
    }
  }
}
