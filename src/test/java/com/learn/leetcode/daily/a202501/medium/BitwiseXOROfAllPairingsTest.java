package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BitwiseXOROfAllPairingsTest {

    @Test
    void xorAllNums1() {
        final int[] nums1 = {2,1,3};
        final int[] nums2 = {10,2,5,0};
        final int expected = 13;
        final int answer = BitwiseXOROfAllPairings.xorAllNums(nums1, nums2);

        assertEquals(expected, answer);
    }

    @Test
    void xorAllNums2() {
        final int[] nums1 = {1,2};
        final int[] nums2 = {3,4};
        final int expected = 0;
        final int answer = BitwiseXOROfAllPairings.xorAllNums(nums1, nums2);

        assertEquals(expected, answer);
    }
}