package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.MaximumMatrixSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumMatrixSumTest {

    @Test
    void maxMatrixSum1() {
        final int[][] matrix = {
                {1,-1},
                {-1,1}
        };
        final long expected = 4L;
        final long result = MaximumMatrixSum.maxMatrixSum(matrix);

        assertEquals(expected, result);
    }

    @Test
    void maxMatrixSum2() {
        final int[][] matrix = {
                {1,2,3},
                {-1,-2,-3},
                {1,2,3}
        };
        final long expected = 16L;
        final long result = MaximumMatrixSum.maxMatrixSum(matrix);

        assertEquals(expected, result);
    }
}