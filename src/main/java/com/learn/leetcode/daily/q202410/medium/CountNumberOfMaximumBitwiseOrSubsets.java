package com.learn.leetcode.daily.q202410.medium;

/**
 * <a href="https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/?envType=daily-question&envId=2024-10-18">Task</a>
 * <br><a href="https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/solutions/5929405/o-2-n-c-7ms-java-8ms-efficient-backtracking/?envType=daily-question&envId=2024-10-18">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Backtracking, Bit Manipulation, Enumeration}
 * </ul>
 * <ul>Hints
 * <li> {@code Can we enumerate all possible subsets?}
 * <li> {@code The maximum bitwise-OR is the bitwise-OR of the whole array.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 16}
 * <li> {@code 1 <= nums[i] <= 105}
 * </ul>
 * <br>@since 1.0.0
 * <br> 18.10.24 21:12
 */
public final class CountNumberOfMaximumBitwiseOrSubsets {
    /**
     * {@code Time Complexity O(2^N)}
     * {@code Space Complexity O(N)}
     * @param nums
     * @return
     */
    public static int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int n : nums) {
            max |= n;
        }
        return dfs(nums, 0, 0, max);
    }
    private static int dfs(int[] nums, int i, int or, int max) {
        if (i == nums.length) {
            return or == max ? 1 : 0;
        }
        return dfs(nums, i + 1, or | nums[i], max) + dfs(nums, i + 1, or, max);
    }
}
