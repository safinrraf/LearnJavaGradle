package com.learn.leetcode.daily.u202411.hard;

import com.learn.leetcode.daily.w2024.u202411.hard.ShortestSubarrayWithSumAtLeastK;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestSubarrayWithSumAtLeastKTest {

    @Test
    void shortestSubarray1() {
        final int[] nums = {1};
        final int k = 1;
        final int expected = 1;
        final int result = ShortestSubarrayWithSumAtLeastK.shortestSubarray(nums, k);

        assertEquals(expected, result);
    }

    @Test
    void shortestSubarray2() {
        final int[] nums = {1, 2};
        final int k = 4;
        final int expected = -1;
        final int result = ShortestSubarrayWithSumAtLeastK.shortestSubarray(nums, k);

        assertEquals(expected, result);
    }

    @Test
    void shortestSubarray3() {
        final int[] nums = {2,-1,2};
        final int k = 3;
        final int expected = 3;
        final int result = ShortestSubarrayWithSumAtLeastK.shortestSubarray(nums, k);

        assertEquals(expected, result);
    }

    @Test
    void shortestSubarray4() {
        final int[] nums = {-34,37,51,3,-12,-50,51,100,-47,99,34,14,-13,89,31,-14,-44,23,-38,6};
        final int k = 151;
        final int expected = 2;
        final int result = ShortestSubarrayWithSumAtLeastK.shortestSubarray(nums, k);

        assertEquals(expected, result);
    }

    @Test
    void shortestSubarray5() {
        final int[] nums = {84,-37,32,40,95};
        final int k = 167;
        final int expected = 3;
        final int result = ShortestSubarrayWithSumAtLeastK.shortestSubarray(nums, k);

        assertEquals(expected, result);
    }

    @Test
    void shortestSubarray6() {
        final int[] nums = {-28,81,-20,28,-29};
        final int k = 89;
        final int expected = 3;
        final int result = ShortestSubarrayWithSumAtLeastK.shortestSubarray(nums, k);

        assertEquals(expected, result);
    }
}