package com.learn.leetcode.daily.a202501.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakingALargeIslandTest {

    @Test
    void largestIsland1() {
        final int[][] grid = {{1, 0}, {0, 1}};
        final int expected = 3;
        final int answer = MakingALargeIsland.largestIsland(grid);

        assertEquals(expected, answer);
    }

    @Test
    void largestIsland2() {
        final int[][] grid = {{1, 1}, {1, 0}};
        final int expected = 4;
        final int answer = MakingALargeIsland.largestIsland(grid);

        assertEquals(expected, answer);
    }

    @Test
    void largestIsland3() {
        final int[][] grid = {{1, 1}, {1, 1}};
        final int expected = 4;
        final int answer = MakingALargeIsland.largestIsland(grid);

        assertEquals(expected, answer);
    }
}