package com.learn.leetcode.daily.w2024.x202412.medium;

/**
 * <a href="https://leetcode.com/problems/special-array-ii/description/?envType=daily-question&envId=2024-12-09">Task</a>
 * <br><a href="https://leetcode.com/problems/special-array-ii/solutions/6127355/simple-prefix-solution-100-beats/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search, Prefix Sum}
 * </ul>
 * <ul>Hints
 * <li> {@code Try to split the array into some non-intersected continuous special sub-arrays.}
 * <li> {@code For each query check that the first and the last elements of that query are in the same sub-array or not.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 10^5}
 * <li> {@code 1 <= nums[i] <= 10^5}
 * <li> {@code 1 <= queries.length <= 10^5}
 * <li> {@code queries[i].length == 2}
 * <li> {@code 0 <= queries[i][0] <= queries[i][1] <= nums.length - 1}
 * </ul>
 * <br>@since 1.0.0
 * <br> 09.12.24 17:34
 */
public final class SpecialArray2 {

    /**
     * <p>An array is considered special if every pair of its adjacent elements contains two numbers with different parity.</p>
     * <p>
     * {@code Time Complexity O(N+Q)}<br>
     * {@code Space Complexity O(N+Q)}
     * </p>
     * @param nums
     * @param queries
     * @return an array of booleans {@code answer} such that {@code answer[i]} is {@code true} if {@code nums[from-i..to-i]} is special.
     */
    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        final int n = nums.length;
        final int[] prefix = new int[n]; // Prefix array to count special pairs
        final boolean[] result = new boolean[queries.length]; // Result array

        // Step 1: Build the prefix array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if ((nums[i - 1] % 2 == 0 && nums[i] % 2 == 0) ||
                    (nums[i - 1] % 2 != 0 && nums[i] % 2 != 0)) {
                prefix[i]++;
            }
        }

        // Step 2: Process each query
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // Calculate the number of special pairs in the range
            int specialCount = prefix[right] - (left > 0 ? prefix[left] : 0);

            // If no special pairs, the result is true; otherwise, false
            result[i] = (specialCount == 0);
        }

        return result;
    }
}
