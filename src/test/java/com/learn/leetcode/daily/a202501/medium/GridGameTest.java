package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridGameTest {

    @Test
    void gridGame1() {
        final int[][] grid = {{2, 5, 4}, {1, 5, 1}};
        final long expected = 4;
        final long answer = GridGame.gridGame(grid);

        assertEquals(expected, answer);
    }

    @Test
    void gridGame2() {
        final int[][] grid = {{3,3,1}, {8,5,2}};
        final long expected = 4;
        final long answer = GridGame.gridGame(grid);

        assertEquals(expected, answer);
    }

    @Test
    void gridGame3() {
        final int[][] grid = {{1,3,1,15}, {1,3,3,1}};
        final long expected = 7;
        final long answer = GridGame.gridGame(grid);

        assertEquals(expected, answer);
    }
}