package com.learn.leetcode.daily.u202411.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidArrangementOfPairsTest {

    @Test
    void validArrangement1() {
        final int[][] pairs = {{5,1},{4,5},{11,9},{9,4}};
        final int[][] expected = {{11,9},{9,4},{4,5},{5,1}};
        final int[][] result = ValidArrangementOfPairs.validArrangement(pairs);

        assertArrayEquals(expected, result);
    }

    @Test
    void validArrangement2() {
        final int[][] pairs = {{1,3},{3,2},{2,1}};
        final int[][] expected = {{1,3},{3,2},{2,1}};
        final int[][] result = ValidArrangementOfPairs.validArrangement(pairs);

        assertArrayEquals(expected, result);
    }

    @Test
    void validArrangement3() {
        final int[][] pairs = {{1,2},{1,3},{2,1}};
        final int[][] expected = {{1,2},{2,1},{1,3}};
        final int[][] result = ValidArrangementOfPairs.validArrangement(pairs);

        assertArrayEquals(expected, result);
    }

    @Test
    void validArrangement4() {
        final int[][] pairs = {{299, 1}, {1, 2}, {1, 3}, {3, 5}, {5, 8}, {8, 3}, {3, 7}, {7, 6}, {6, 9}, {9, 3},
                {3, 6}, {6, 7}, {7, 3}, {3, 8}, {8, 5}, {5, 3}, {3, 1}, {2, 1}};
        final int[][] expected = {{299,1},{1,3},{3,8},{8,5},{5,3},{3,6},{6,7},{7,3},{3,7},{7,6},{6,9},
                {9,3},{3,5},{5,8},{8,3},{3,1},{1,2},{2,1}};
        final int[][] result = ValidArrangementOfPairs.validArrangement(pairs);

        assertArrayEquals(expected, result);
    }
}