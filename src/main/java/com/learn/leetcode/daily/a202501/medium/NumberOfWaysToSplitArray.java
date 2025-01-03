package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/number-of-ways-to-split-array/?envType=daily-question&envId=2025-01-03">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Prefix Sum}
 * </ul>
 * <ul>Hints
 * <li> {@code For any index i, how can we find the sum of the first (i+1) elements from the sum of the first i elements?}
 * <li> {@code If the total sum of the array is known, how can we check if the sum of the first (i+1) elements greater than or equal to the remaining elements?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 2 <= nums.length <= 10^5}
 * <li> {@code -10^5 <= nums[i] <= 10^5}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 03.01.25 20:15
 */
public final class NumberOfWaysToSplitArray {

    /**
     *
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param nums a 0-indexed integer array.
     * @return the number of <b>valid splits</b> in {@code nums}.
     */
    public static int waysToSplitArray(int[] nums) {
        final int N = nums.length;
        final long[] prefix_sum = new long[N];
        int result = 0;
        prefix_sum[0] = nums[0];

        for(int i = 1; i < N; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + nums[i];
        }

        for(int i = 0; i < N - 1; i++) {
            if(prefix_sum[i] >= prefix_sum[N - 1] - prefix_sum[i]) {
                result++;
            }
        }

        return result;
    }
}
