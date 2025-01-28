package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfFishInGridTest {

    @Test
    void findMaxFish1() {
        final int[][] grid = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
        final int expected = 7;
        final int answer = MaximumNumberOfFishInGrid.findMaxFish(grid);

        assertEquals(expected, answer);
    }

    @Test
    void findMaxFish2() {
        final int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};
        final int expected = 1;
        final int answer = MaximumNumberOfFishInGrid.findMaxFish(grid);

        assertEquals(expected, answer);
    }
}