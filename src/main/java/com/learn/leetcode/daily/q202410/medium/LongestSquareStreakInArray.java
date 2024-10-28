package com.learn.leetcode.daily.q202410.medium;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/longest-square-streak-in-an-array/description/?envType=daily-question&envId=2024-10-28">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Binary Search, Dynamic Programming, Sorting}
 * </ul>
 * <ul>Hints
 * <li> {@code With the constraints, the length of the longest square streak possible is 5.}
 * <li> {@code Store the elements of nums in a set to quickly check if it exists.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 2 <= nums.length <= 10^5}
 * <li> {@code 2 <= nums[i] <= 10^5}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 28.10.24 17:37
 */
public final class LongestSquareStreakInArray {

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(N)}
     * @param nums
     * @return Return the length of the <b>longest square streak</b> in nums, or return {@code -1} if there is no <b>square streak</b>.
     */
    public static int longestSquareStreak(int[] nums) {
        final HashSet<Long> set = new HashSet<>(nums.length);
        for(var item : nums) {
            set.add((long) item);
        }
        var result = -1;
        for (int item : nums) {
            var num = item;
            var tmp_result = 1;
            while (set.contains((1L * num) * (1L * num))) {
                num *= num;
                tmp_result++;
                result = Math.max(result, tmp_result);
            }
        }

        return result;
    }
}
