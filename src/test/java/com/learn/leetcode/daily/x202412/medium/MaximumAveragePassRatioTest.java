package com.learn.leetcode.daily.x202412.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumAveragePassRatioTest {

    @Test
    void maxAverageRatio1() {
        final int[][] classes = {{1,2},{3,5},{2,2}};
        final int extraStudents = 2;
        final double expected = 0.78333;
        final double result = MaximumAveragePassRatio.maxAverageRatio(classes, extraStudents);

        assertEquals(expected, result);
    }

    @Test
    void maxAverageRatio2() {
        final int[][] classes = {{2,4},{3,9},{4,5},{2,10}};
        final int extraStudents = 4;
        final double expected = 0.53485;
        final double result = MaximumAveragePassRatio.maxAverageRatio(classes, extraStudents);

        assertEquals(expected, result);
    }
}