package com.learn.leetcode.easy.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/578/">Task</a>
 */
public final class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
