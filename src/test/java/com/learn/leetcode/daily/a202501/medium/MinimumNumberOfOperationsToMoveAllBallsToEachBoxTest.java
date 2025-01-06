package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfOperationsToMoveAllBallsToEachBoxTest {

    @Test
    void minOperations1() {
        final String boxes = "110";
        final int[] expected = {1,1,3};
        final int[] result = MinimumNumberOfOperationsToMoveAllBallsToEachBox.minOperations(boxes);

        assertArrayEquals(expected, result);
    }

    @Test
    void minOperations2() {
        final String boxes = "001011";
        final int[] expected = {11,8,5,4,3,4};
        final int[] result = MinimumNumberOfOperationsToMoveAllBallsToEachBox.minOperations(boxes);

        assertArrayEquals(expected, result);
    }
}