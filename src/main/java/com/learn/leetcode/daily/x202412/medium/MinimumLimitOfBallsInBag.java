package com.learn.leetcode.daily.x202412.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/?envType=daily-question&envId=2024-12-07">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search}
 * </ul>
 * <ul>Hints
 * <li> {@code Let's change the question if we know the maximum size of a bag what is the minimum number of bags you can make.}
 * <li> {@code note that as the maximum size increases the minimum number of bags decreases so we can binary search the maximum size.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 10^5}
 * <li> {@code 1 <= maxOperations, nums[i] <= 10^9}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 07.12.24 17:42
 */
public final class MinimumLimitOfBallsInBag {

    /**
     * {@code Time Complexity O(NLog(Max(Nums)))}
     * {@code Space Complexity O(1)}
     *
     * @param nums You are given an integer array {@code nums{} where the {@code i-th} bag contains {@code nums[i]} balls.
     * @param maxOperations
     * @return the minimum possible penalty after performing the operations.
     */
    public static int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        while (low < high) {
            int mid = (low + high) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += (n - 1) / mid;
            }
            if (ops <= maxOperations) high = mid;
            else low = mid + 1;
        }
        return high;
    }
}
