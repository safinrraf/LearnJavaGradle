package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MakeLexicographicallySmallestArrayBySwappingElementsTest {

    @Test
    void lexicographicallySmallestArray1() {
        final int[] nums = {1,5,3,9,8};
        final int limit = 2;
        final int[] expected = {1,3,5,8,9};
        final int[] answer = MakeLexicographicallySmallestArrayBySwappingElements.lexicographicallySmallestArray(nums, limit);

        assertArrayEquals(expected, answer);
    }

    @Test
    void lexicographicallySmallestArray2() {
        final int[] nums = {1,7,6,18,2,1};
        final int limit = 3;
        final int[] expected = {1,6,7,18,1,2};
        final int[] answer = MakeLexicographicallySmallestArrayBySwappingElements.lexicographicallySmallestArray(nums, limit);

        assertArrayEquals(expected, answer);
    }

    @Test
    void lexicographicallySmallestArray3() {
        final int[] nums = {1,7,28,19,10};
        final int limit = 3;
        final int[] expected = {1,7,28,19,10};
        final int[] answer = MakeLexicographicallySmallestArrayBySwappingElements.lexicographicallySmallestArray(nums, limit);

        assertArrayEquals(expected, answer);
    }
}