package com.learn.leetcode.daily.x202412.medium;

import com.learn.leetcode.daily.w2024.x202412.medium.MaximumBeautyOfAnArrayAfterApplyingOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumBeautyOfAnArrayAfterApplyingOperationTest {

    @Test
    void maximumBeauty1() {
        final int[] nums = {4,6,1,2};
        final int k = 2;
        final int expected = 3;
        final int result = MaximumBeautyOfAnArrayAfterApplyingOperation.maximumBeauty(nums, k);

        assertEquals(expected, result);
    }

    @Test
    void maximumBeauty2() {
        final int[] nums = {1,1,1,1};
        final int k = 10;
        final int expected = 4;
        final int result = MaximumBeautyOfAnArrayAfterApplyingOperation.maximumBeauty(nums, k);

        assertEquals(expected, result);
    }
}