package com.learn.leetcode.daily.b202502.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumAscendingSubarraySumTest {

    @Test
    void maxAscendingSum1() {
        final int[] nums = {10,20,30,5,10,50};
        final int expected = 65;
        final int answer = MaximumAscendingSubarraySum.maxAscendingSum(nums);

        assertEquals(expected, answer);
    }

    @Test
    void maxAscendingSum2() {
        final int[] nums = {10,20,30,40,50};
        final int expected = 150;
        final int answer = MaximumAscendingSubarraySum.maxAscendingSum(nums);

        assertEquals(expected, answer);
    }

    @Test
    void maxAscendingSum3() {
        final int[] nums = {12,17,15,13,10,11,12};
        final int expected = 33;
        final int answer = MaximumAscendingSubarraySum.maxAscendingSum(nums);

        assertEquals(expected, answer);
    }

    @Test
    void maxAscendingSum4() {
        final int[] nums = {12};
        final int expected = 12;
        final int answer = MaximumAscendingSubarraySum.maxAscendingSum(nums);

        assertEquals(expected, answer);
    }

    @Test
    void maxAscendingSum5() {
        final int[] nums = {12,11,10,9,8};
        final int expected = 12;
        final int answer = MaximumAscendingSubarraySum.maxAscendingSum(nums);

        assertEquals(expected, answer);
    }
}