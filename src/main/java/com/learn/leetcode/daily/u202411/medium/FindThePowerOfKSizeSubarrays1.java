package com.learn.leetcode.daily.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/?envType=daily-question&envId=2024-11-16">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Sliding Window}
 * </ul>
 * <ul>Hints
 * <li> {@code Can we use a brute force solution with nested loops and HashSet?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= n == nums.length <= 500}
 * <li> {@code 1 <= nums[i] <= 10^5}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 16.11.24 16:10
 */
public final class FindThePowerOfKSizeSubarrays1 {

    /**
     * {@code Time Complexity O(N * K)}
     * {@code Space Complexity O(N − K + 1)}
     *
     * @param nums
     * @param k
     * @return an integer array {@code results} of size {@code n - k + 1}, where {@code results[i]} is the power of {@code nums[i..(i + k - 1)]}.
     */
    public static int[] resultsArray(int[] nums, int k) {
        if(nums.length == 1 || k == 1) {
            return nums;
        }
        final var result = new int[nums.length - k + 1];
        int ans = 0, curr;

        for (int right = 0; right <= nums.length - k; right++) {
            curr = -1;

            for (int j = right; j < right + k - 1; j++) {
                if(nums[j + 1] - nums[j] == 1) {
                    curr = j;
                } else {
                    curr = -1;
                    break;
                }
            }

            result[ans++] = curr == -1 ? -1 : nums[curr + 1];
        }

        return result;
    }
}
