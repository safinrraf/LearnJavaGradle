package com.learn.leetcode.daily.u202411.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MinimumObstacleRemovalToReachCornerTest {

    @Test
    void minimumObstacles1() {
        final int[][] grid = {
                {0,1,1},
                {1,1,0},
                {1,1,0}
        };
        final int expected = 2;
        final int result = MinimumObstacleRemovalToReachCorner.minimumObstacles(grid);

        assertEquals(expected, result);
    }

    @Test
    void minimumObstacles2() {
        final int[][] grid = {
                {0,1,0,0,0},
                {0,1,0,1,0},
                {0,0,0,1,0}
        };
        final int expected = 0;
        final int result = MinimumObstacleRemovalToReachCorner.minimumObstacles(grid);

        assertEquals(expected, result);
    }
}