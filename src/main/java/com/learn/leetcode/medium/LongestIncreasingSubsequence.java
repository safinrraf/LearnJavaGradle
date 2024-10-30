package com.learn.leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/description/">Task</a>
 * <br><a href="https://en.wikipedia.org/wiki/Longest_increasing_subsequence">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search, Dynamic Programming}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 2500}
 * <li> {@code -10^4 <= nums[i] <= 10^4}
 * </ul>
 * <br>@since 1.0.0
 * <br> 30.10.24 19:30
 */
public final class LongestIncreasingSubsequence {
    /**
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        // Edge case: if array is empty, LIS length is 0
        if (nums.length == 0) {
            return 0;
        }

        // Array to store the end values of the increasing subsequences
        int[] tail = new int[nums.length];
        int length = 0; // Represents the length of the LIS

        for (int num : nums) {
            // Find the index where num can replace in tail
            int index = Arrays.binarySearch(tail, 0, length, num);

            // If num is not found, binarySearch returns -(insertion_point) - 1
            if (index < 0) {
                index = -(index + 1);
            }

            // Update the tail array with num at the found index
            tail[index] = num;

            // If num is added at the end of the tail array, increase the length
            if (index == length) {
                length++;
            }
        }

        return length;
    }
}
