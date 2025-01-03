package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfWaysToSplitArrayTest {

    @Test
    void waysToSplitArray1() {
        final int[] nums = {10,4,-8,7};
        final int expected = 2;
        final int result = NumberOfWaysToSplitArray.waysToSplitArray(nums);

        assertEquals(expected, result);
    }

    @Test
    void waysToSplitArray2() {
        final int[] nums = {2,3,1,0};
        final int expected = 2;
        final int result = NumberOfWaysToSplitArray.waysToSplitArray(nums);

        assertEquals(expected, result);
    }

    @Test
    void waysToSplitArray3() {
        final int[] nums = {0,0};
        final int expected = 1;
        final int result = NumberOfWaysToSplitArray.waysToSplitArray(nums);

        assertEquals(expected, result);
    }

    @Test
    void waysToSplitArray4() {
        final int[] nums = {9,9,9};
        final int expected = 1;
        final int result = NumberOfWaysToSplitArray.waysToSplitArray(nums);

        assertEquals(expected, result);
    }

    @Test
    void waysToSplitArray5() {
        final int[] nums = {-1,-2};
        final int expected = 1;
        final int result = NumberOfWaysToSplitArray.waysToSplitArray(nums);

        assertEquals(expected, result);
    }
}