package com.learn.leetcode.daily.u202411.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumTimeToVisitACellInAGridTest {

    /**
     * <b>Explanation</b>: One of the paths that we can take is the following:
     * <li>- at t = 0, we are on the cell (0,0).
     * <li>- at t = 1, we move to the cell (0,1). It is possible because grid[0][1] <= 1.
     * <li>- at t = 2, we move to the cell (1,1). It is possible because grid[1][1] <= 2.
     * <li>- at t = 3, we move to the cell (1,2). It is possible because grid[1][2] <= 3.
     * <li>- at t = 4, we move to the cell (1,1). It is possible because grid[1][1] <= 4.
     * <li>- at t = 5, we move to the cell (1,2). It is possible because grid[1][2] <= 5.
     * <li>- at t = 6, we move to the cell (1,3). It is possible because grid[1][3] <= 6.
     * <li>- at t = 7, we move to the cell (2,3). It is possible because grid[2][3] <= 7.
     * <br>The final time is 7. It can be shown that it is the minimum time possible.
     */
    @Test
    void minimumTime1() {
        final int[][] grid = {
                {0,1,3,2},
                {5,1,2,5},
                {4,3,8,6}
        };
        final int expected = 7;
        final int result = MinimumTimeToVisitACellInAGrid.minimumTime(grid);

        assertEquals(expected, result);
    }

    @Test
    void minimumTime2() {
        final int[][] grid = {
                {0,2,4},
                {3,2,1},
                {1,0,4}
        };
        final int expected = -1;
        final int result = MinimumTimeToVisitACellInAGrid.minimumTime(grid);

        assertEquals(expected, result);
    }
}