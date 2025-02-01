package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.FlipColumnsForMaximumNumberOfEqualRows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FlipColumnsForMaximumNumberOfEqualRowsTest {

    @Test
    void maxEqualRowsAfterFlips1() {
        final int[][] matrix = {{0,1},{1,1}};
        final int expected = 1;
        final int result = FlipColumnsForMaximumNumberOfEqualRows.maxEqualRowsAfterFlips(matrix);

        assertEquals(expected, result);
    }

    @Test
    void maxEqualRowsAfterFlips2() {
        final int[][] matrix = {{0,1},{1,0}};
        final int expected = 2;
        final int result = FlipColumnsForMaximumNumberOfEqualRows.maxEqualRowsAfterFlips(matrix);

        assertEquals(expected, result);
    }

    @Test
    void maxEqualRowsAfterFlips3() {
        final int[][] matrix = {{0,0,0},{0,0,1},{1,1,0}};
        final int expected = 2;
        final int result = FlipColumnsForMaximumNumberOfEqualRows.maxEqualRowsAfterFlips(matrix);

        assertEquals(expected, result);
    }
}