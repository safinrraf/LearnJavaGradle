package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindThePrefixCommonArrayOfTwoArraysTest {

    @Test
    void findThePrefixCommonArray1() {
        final int[] A = {1,3,2,4};
        final int[] B = {3,1,2,4};
        final int[] expected = {0,2,3,4};
        final int[] answer = FindThePrefixCommonArrayOfTwoArrays.findThePrefixCommonArray(A, B);

        assertArrayEquals(expected, answer);
    }

    @Test
    void findThePrefixCommonArray2() {
        final int[] A = {2,3,1};
        final int[] B = {3,1,2};
        final int[] expected = {0,1,3};
        final int[] answer = FindThePrefixCommonArrayOfTwoArrays.findThePrefixCommonArray(A, B);

        assertArrayEquals(expected, answer);
    }
}