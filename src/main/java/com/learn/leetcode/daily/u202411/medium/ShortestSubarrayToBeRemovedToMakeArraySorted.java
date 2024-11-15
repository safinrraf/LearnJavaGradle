package com.learn.leetcode.daily.u202411.medium;


/**
 * <a href="https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description/?envType=daily-question&envId=2024-11-15">Task</a>
 * <br><a href="https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/solutions/833000/simple-java-2ms-solution-with-comments/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Two Pointers, Binary Search, Stack, Monotonic Stack}
 * </ul>
 * <ul>Hints
 * <li> {@code The key is to find the longest non-decreasing subarray starting with the first element or ending with the last element, respectively.}
 * <li> {@code After removing some subarray, the result is the concatenation of a sorted prefix and a sorted suffix, where the last element of the prefix is smaller than the first element of the suffix.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= arr.length <= 105}
 * <li> {@code 0 <= arr[i] <= 109}
 * </ul>
 * <br>@since 1.0.0
 * <br> 15.11.24 10:21
 */
public final class ShortestSubarrayToBeRemovedToMakeArraySorted {

    /**
     *
     * @param arr
     * @return the length of the shortest subarray to remove.
     */
    public static int findLengthOfShortestSubarray(int[] arr) {
        final int n = arr.length;
        int j = n - 1;
        //A[j....n] is monotone increasing
        while(j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }

        int result = j;
        for(int i = 0; i < j; i++) {
            //A[0....i] is monotone increasing
            if(i > 0 && arr[i - 1] > arr[i]) {
                break;
            }

            //compare arr[0...i] with arr[j] so that arr[0....i, j.....n] is monotone increasing
            while(j < n && arr[i] > arr[j]) {
                j++;
            }

            result = Math.min(result, j - i - 1);
        }

        return result;
    }
}
