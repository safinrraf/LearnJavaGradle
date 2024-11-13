package com.learn.leetcode.daily.u202411.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/count-the-number-of-fair-pairs/?envType=daily-question&envId=2024-11-13">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Two Pointers, Binary Search, Sorting}
 * </ul>
 * <ul>Hints
 * <li> {@code Sort the array in ascending order.}
 * <li> {@code For each number in the array, keep track of the smallest and largest numbers in the array that can form a fair pair with this number.}
 * <li> {@code As you move to larger number, both boundaries move down.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 10^5}
 * <li> {@code nums.length == n}
 * <li> {@code -10^9 <= nums[i] <= 10^9}
 * <li> {@code -109 <= lower <= upper <= 10^9}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 13.11.24 08:19
 */
public final class CountTheNumberOfFairPairs {

    /**
     * <ul>A pair (i, j) is fair if:
     * <li>{@code 0 <= i < j < n}
     * <li>{@code lower <= nums[i] + nums[j] <= upper}
     * </ul><br>
     * {@code Time Complexity O(...)}
     * {@code Space Complexity O(...)}
     *
     * @param nums a 0-indexed integer array.
     * @param lower lower boundary.
     * @param upper upper boundary.
     * @return the number of fair pairs
     */
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int low = lowerBound(nums, i + 1, nums.length, lower - nums[i]);
            int up = upperBound(nums, i + 1, nums.length, upper - nums[i]);
            ans += up - low;
        }
        return ans;
    }

    private static int lowerBound(int[] v, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (v[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    private static int upperBound(int[] v, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (v[mid] > target) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
