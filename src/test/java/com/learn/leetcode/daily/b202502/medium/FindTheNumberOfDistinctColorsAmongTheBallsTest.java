package com.learn.leetcode.daily.b202502.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheNumberOfDistinctColorsAmongTheBallsTest {

    @Test
    void queryResults1() {
        final int limit = 4;
        final int[][] queries = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        final int[] expected = {1,2,2,3};
        final int[] answer = FindTheNumberOfDistinctColorsAmongTheBalls.queryResults(limit, queries);

        assertArrayEquals(expected, answer);
    }

    @Test
    void queryResults2() {
        final int limit = 4;
        final int[][] queries = {{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}};
        final int[] expected = {1,2,2,3,4};
        final int[] answer = FindTheNumberOfDistinctColorsAmongTheBalls.queryResults(limit, queries);

        assertArrayEquals(expected, answer);
    }
}