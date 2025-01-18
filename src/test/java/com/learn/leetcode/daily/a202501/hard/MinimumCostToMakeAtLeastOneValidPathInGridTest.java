package com.learn.leetcode.daily.a202501.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumCostToMakeAtLeastOneValidPathInGridTest {

    @Test
    void minCost1() {
        final int[][] grid = {{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}};
        final int expected = 3;
        final int answer = MinimumCostToMakeAtLeastOneValidPathInGrid.minCost(grid);

        assertEquals(expected, answer);
    }

    @Test
    void minCost2() {
        final int[][] grid = {{1, 1, 3}, {3, 2, 2}, {1, 1, 4}};
        final int expected = 0;
        final int answer = MinimumCostToMakeAtLeastOneValidPathInGrid.minCost(grid);

        assertEquals(expected, answer);
    }

    @Test
    void minCost3() {
        final int[][] grid = {{1,2}, {4, 3}};
        final int expected = 1;
        final int answer = MinimumCostToMakeAtLeastOneValidPathInGrid.minCost(grid);

        assertEquals(expected, answer);
    }
}