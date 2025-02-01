package com.learn.leetcode.daily.x202412.easy;

import com.learn.leetcode.daily.w2024.x202412.easy.FinalArrayStateAfterKMultiplicationOperations1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinalArrayStateAfterKMultiplicationOperations1Test {

    @Test
    void getFinalState1() {
        final int[] nums = {2,1,3,5,6};
        final int k = 5;
        final int multiplier = 2;
        final int[] expected = {8,4,6,5,6};
        final int[] result = FinalArrayStateAfterKMultiplicationOperations1.getFinalState(nums, k, multiplier);

        assertArrayEquals(expected, result);
    }

    @Test
    void getFinalState2() {
        final int[] nums = {1,2};
        final int k = 3;
        final int multiplier = 4;
        final int[] expected = {16,8};
        final int[] result = FinalArrayStateAfterKMultiplicationOperations1.getFinalState(nums, k, multiplier);

        assertArrayEquals(expected, result);
    }
}