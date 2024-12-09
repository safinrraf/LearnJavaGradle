package com.learn.leetcode.daily.x202412.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SpecialArray2Test {

    @Test
    void isArraySpecial1() {
        final int[] nums = {3,4,1,2,6};
        final int[][] queries = {{0,4}};
        final boolean[] expected = {false};
        final boolean[] result = SpecialArray2.isArraySpecial(nums, queries);

        assertArrayEquals(expected, result);
    }

    @Test
    void isArraySpecial2() {
        final int[] nums = {4,3,1,6};
        final int[][] queries = {{0,2},{2,3}};
        final boolean[] expected = {false,true};
        final boolean[] result = SpecialArray2.isArraySpecial(nums, queries);

        assertArrayEquals(expected, result);
    }
}