package com.learn.leetcode.daily.b202502.easy;

/**
 * <a href="https://leetcode.com/problems/maximum-ascending-subarray-sum/description/?envType=daily-question&envId=2025-02-04">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array}
 * </ul>
 * <ul>Hints
 * <li> {@code It is fast enough to check all possible sub-arrays.}
 * <li> {@code The end of each ascending subarray will be the start of the next.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 100}
 * <li> {@code 1 <= nums[i] <= 100}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 04.02.25 08:21
 */
public final class MaximumAscendingSubarraySum {

    /**
     *
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param nums an array of positive integers.
     * @return the maximum possible sum of an <b>ascending</b> subarray in {@code nums}.
     */
    public static int maxAscendingSum(int[] nums) {
        int inc_sum =  nums[0];
        int result = inc_sum;

        // Iterate through array comparing adjacent elements
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                // If next element is larger, extend increasing sequence
                inc_sum += nums[i];
            } else {
                // else reset to the amount of the possibly first element in the ascending sub-array.
                inc_sum = nums[i];
            }

            // Update the result
            result = Math.max(result, inc_sum);
        }
        return result;
    }
}
