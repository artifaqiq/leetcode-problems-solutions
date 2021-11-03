package leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class M01_Merge_Sort {

  @Test
  public void test() {
    int[] ints = {5, 6, 7, 3, 5, 6, 7, 8, 8, 2, 2, 1, -1, 2, 3, 4, 5, 6, 7};
//    int[] ints = {5, 6, 7, 1, 2};
    new Solution().mergeSort(ints);
    System.out.println(Arrays.stream(ints).boxed().collect(Collectors.toList()));
    assertThat(IntStream.range(0, ints.length - 1).noneMatch(i -> ints[i] > ints[i + 1]), equalTo(true));
  }

  class Solution {

    public void selectionSort(int[] ints) {
      for (int i = 0; i < ints.length; i++) {
        for (int j = i + 1; j < ints.length; j++) {
          if (ints[i] > ints[j]) {
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
          }
        }
      }
    }

    public void insertionSort(int[] nums) {
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] < nums[i - 1]) {
          int numToInsert = nums[i];
          for (int j = i - 1; j >= 0; j--) {
            nums[j + 1] = nums[j];
            if (numToInsert >= nums[j]) {
              nums[j + 1] = numToInsert;
              break;
            }
            nums[j] = numToInsert;
          }

        }
      }
    }

    public void mergeSort(int[] nums) {
      mergeSort(nums, 0, nums.length);
    }

    private void mergeSort(int[] nums, int l, int r) {
      System.out.printf("Before merge: l = %d r = %d array = ", l, r);
      for (int i0 = l; i0 < r; i0++) {
        System.out.print(nums[i0] + " ");
      }
      System.out.println();
      int length = r - l;

      if (length == 2) {
        if (nums[l] > nums[l + 1]) {
          int temp = nums[l];
          nums[l] = nums[l + 1];
          nums[l + 1] = temp;
        }
      } else if (length > 2) {
        mergeSort(nums, l, l + length / 2);
        mergeSort(nums, l + length / 2, r);
        merge(nums, l, l + length / 2, l + length / 2, r);
      }

      System.out.printf("After merge: l = %d r = %d array = ", l, r);
      for (int i0 = l; i0 < r; i0++) {
        System.out.print(nums[i0] + " ");
      }
      System.out.println();
    }

    private void merge(int[] nums, int leftStart, int leftEnd, int rightStart, int rightEnd) {
      int[] leftArrayCopy = new int[leftEnd - leftStart];
      int[] rightArrayCopy = new int[rightEnd - rightStart];
      for (int i = 0, j = leftStart; i < leftArrayCopy.length; i++, j++) {
        leftArrayCopy[i] = nums[j];
      }
      for (int i = 0, j = rightStart; i < rightArrayCopy.length; i++, j++) {
        rightArrayCopy[i] = nums[j];
      }

      for (int i = leftStart, leftPointer = 0, rightPointer = 0; i < rightEnd; i++) {
        if (leftPointer == leftArrayCopy.length) {
          nums[i] = rightArrayCopy[rightPointer++];
        } else if (rightPointer == rightArrayCopy.length) {
          nums[i] = leftArrayCopy[leftPointer++];
        } else {
          if (rightArrayCopy[rightPointer] < leftArrayCopy[leftPointer]) {
            nums[i] = rightArrayCopy[rightPointer++];
          } else {
            nums[i] = leftArrayCopy[leftPointer++];
          }
        }
      }
    }
  }

}

