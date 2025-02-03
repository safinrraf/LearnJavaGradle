package com.learn.leetcode.daily.b202502.easy;

/**
 * <a href="https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/?envType=daily-question&envId=2025-02-03">Task</a>
 * <br><a href="https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/editorial/?envType=daily-question&envId=2025-02-03">Explanation</a>
 * <ul>Topics
 * <li> {@code Array}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 50}
 * <li> {@code 1 <= nums[i] <= 50}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 03.02.25 08:40
 */
public final class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    /**
     *
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param nums
     * @return the length of the <b>longest</b> subarray of nums which is either strictly increasing or strictly decreasing.
     */
    public static int longestMonotonicSubarray(int[] nums) {
        int max_increasing = 0;
        int max_decreasing = 0;
        int result_increasing = 0;
        int result_decreasing = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) {
                //decreasing, then I am fixing the result of increasing sequence
                result_increasing = Math.max(result_increasing, max_increasing);
                max_increasing = 0;
                max_decreasing++;

            }else if (nums[i - 1] < nums[i]) {
                //increasing, then I am fixing the result of decreasing sequence
                result_decreasing = Math.max(result_decreasing, max_decreasing);
                max_decreasing = 0;
                max_increasing++;
            } else {
                //both numbers are equal, then it is no more strictly increasing or decreasing.
                result_increasing = Math.max(result_increasing, max_increasing);
                result_decreasing = Math.max(result_decreasing, max_decreasing);
                max_decreasing = 0;
                max_increasing = 0;
            }
        }
        result_increasing = Math.max(result_increasing, max_increasing);
        result_decreasing = Math.max(result_decreasing, max_decreasing);
        //adding a first number of the first pair.
        return Math.max(1, Math.max(result_increasing, result_decreasing) + 1);
    }

    public int longestMonotonicSubarray_the_same_as_mine_but_better(int[] nums) {
        // Track current lengths of increasing and decreasing sequences
        int incLength = 1, decLength = 1;
        int maxLength = 1;

        // Iterate through array comparing adjacent elements
        for (int pos = 0; pos < nums.length - 1; pos++) {
            if (nums[pos + 1] > nums[pos]) {
                // If next element is larger, extend increasing sequence
                incLength++;
                decLength = 1; // Reset decreasing sequence
            } else if (nums[pos + 1] < nums[pos]) {
                // If next element is smaller, extend decreasing sequence
                decLength++;
                incLength = 1; // Reset increasing sequence
            } else {
                // If elements are equal, reset both sequences
                incLength = 1;
                decLength = 1;
            }

            // Update max length considering both sequences
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }
        return maxLength;
    }
}
