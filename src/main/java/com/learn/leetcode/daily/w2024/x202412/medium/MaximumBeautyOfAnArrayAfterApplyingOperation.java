package com.learn.leetcode.daily.w2024.x202412.medium;


/**
 * <a href="https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/?envType=daily-question&envId=2024-12-11">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/solutions/6134554/beats-100-proof-beginner-freindly-java-concise-code/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search, Sliding Window, Sorting}
 * </ul>
 * <ul>Hints
 * <li> {@code Sort the array.}
 * <li> {@code The problem becomes the following: find maximum subarray A[i … j] such that A[j] - A[i] ≤ 2 * k.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 10^5}
 * <li> {@code 0 <= nums[i], k <= 10^5}
 * </ul>
 * <br>@since 1.0.0
 * <br> 11.12.24 08:35
 */
public final class MaximumBeautyOfAnArrayAfterApplyingOperation {

    /**
     *
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}<br>
     * </p>
     * @param nums a 0-indexed array {@code nums} and a non-negative integer {@code k}.
     * @param k
     * @return the maximum possible beauty of the array {@code nums} after applying the operation any number of times.
     */
    public static int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }

        int maxBeauty = 0;
        int maxValue = 0;

        for (final var num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        final int[] count = new int[maxValue + 1];

        for (final var num : nums) {
            count[Math.max(num - k, 0)]++;
            count[Math.min(num + k + 1, maxValue)]--;
        }

        int currentSum = 0;

        for (final var val : count) {
            currentSum += val;
            maxBeauty = Math.max(maxBeauty, currentSum);
        }

        return maxBeauty;
    }
}
