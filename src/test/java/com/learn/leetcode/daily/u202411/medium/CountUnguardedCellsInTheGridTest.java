package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.CountUnguardedCellsInTheGrid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountUnguardedCellsInTheGridTest {

    @Test
    void countUnguarded1() {
        final int m = 4;
        final int n = 6;
        final int[][] guards = {{0,0},{1,1},{2,3}};
        final int[][] walls = {{0,1},{2,2},{1,4}};
        final int expected = 7;
        final int result = CountUnguardedCellsInTheGrid.countUnguarded(m, n, guards, walls);

        assertEquals(expected, result);
    }

    @Test
    void countUnguarded2() {
        final int m = 3;
        final int n = 3;
        final int[][] guards = {{1,1}};
        final int[][] walls = {{0,1},{1,0},{2,1},{1,2}};
        final int expected = 4;
        final int result = CountUnguardedCellsInTheGrid.countUnguarded(m, n, guards, walls);

        assertEquals(expected, result);
    }
}