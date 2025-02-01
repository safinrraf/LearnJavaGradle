package com.learn.leetcode.daily.w2024.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/maximum-xor-for-each-query/description/?envType=daily-question&envId=2024-11-08">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-xor-for-each-query/solutions/6021142/easiest-solution-beats-100-c-java-python3-javascript/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Bit Manipulation, Prefix Sum}
 * </ul>
 * <ul>Hints
 * <li> {@code Note that the maximum possible XOR result is always 2^(maximumBit) - 1}
 * <li> {@code So the answer for a prefix is the XOR of that prefix XORed with 2^(maximumBit)-1}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code nums.length == n}
 * <li> {@code 1 <= n <= 10^5}
 * <li> {@code 1 <= maximumBit <= 20}
 * <li> {@code 0 <= nums[i] < 2^maximumBit}
 * <li> {@code nums is sorted in ascending order.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 08.11.24 08:35
 */
public final class MaximumXorForEachQuery {

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(N)}
     * @param nums
     * @param maximumBit
     * @return an array answer, where {@code answer[i]} is the answer to the {@code i-th} query.
     */
    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xorr = nums[0];
        int maxXor = (1 << maximumBit) - 1;

        for (int i = 1; i < n; i++) {
            xorr ^= nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = xorr ^ maxXor;
            xorr ^= nums[n - 1 - i];
        }

        return ans;
    }
}



