package com.learn.leetcode.daily.b202502.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarrayTest {

    @Test
    void longestMonotonicSubarray0() {
        final int[] nums = {1,4,4,1,2,3,4,1,2,3,4,5};
        final int expected = 5;
        final int answer = LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.longestMonotonicSubarray(nums);

        assertEquals(expected, answer);
    }

    @Test
    void longestMonotonicSubarray1() {
        final int[] nums = {1,4,3,3,2};
        final int expected = 2;
        final int answer = LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.longestMonotonicSubarray(nums);

        assertEquals(expected, answer);
    }

    @Test
    void longestMonotonicSubarray2() {
        final int[] nums = {3,3,3,3};
        final int expected = 1;
        final int answer = LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.longestMonotonicSubarray(nums);

        assertEquals(expected, answer);
    }

    @Test
    void longestMonotonicSubarray3() {
        final int[] nums = {3,2,1};
        final int expected = 3;
        final int answer = LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.longestMonotonicSubarray(nums);

        assertEquals(expected, answer);
    }

    @Test
    void longestMonotonicSubarray4() {
        final int[] nums = {3,20,21,34};
        final int expected = 4;
        final int answer = LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.longestMonotonicSubarray(nums);

        assertEquals(expected, answer);
    }

    @Test
    void longestMonotonicSubarray5() {
        final int[] nums = {10,9,8,7,6,5};
        final int expected = 6;
        final int answer = LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.longestMonotonicSubarray(nums);

        assertEquals(expected, answer);
    }

    @Test
    void longestMonotonicSubarray6() {
        final int[] nums = {10,9,8,7,6,5,6,7,8,9,10,11};
        final int expected = 7;
        final int answer = LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.longestMonotonicSubarray(nums);

        assertEquals(expected, answer);
    }

    @Test
    void longestMonotonicSubarray7() {
        final int[] nums = {1,10,10};
        final int expected = 2;
        final int answer = LongestStrictlyIncreasingOrStrictlyDecreasingSubarray.longestMonotonicSubarray(nums);

        assertEquals(expected, answer);
    }
}