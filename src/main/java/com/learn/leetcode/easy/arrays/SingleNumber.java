package com.learn.leetcode.easy.arrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/">Task</a>
 * */
public final class SingleNumber {
    public static int singleNumber(int[] nums) {
        return Arrays.stream(nums)
                .reduce(0, (a, b) -> a ^ b);
    }
}
