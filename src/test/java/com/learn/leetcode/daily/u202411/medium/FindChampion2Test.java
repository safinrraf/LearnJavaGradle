package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.FindChampion2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindChampion2Test {

    @Test
    void findChampion1() {
        final int n = 3;
        final int[][] edges = {{0,1},{1,2}};
        final int expected = 0;
        final int result = FindChampion2.findChampion(n, edges);

        assertEquals(expected, result);
    }

    @Test
    void findChampion2() {
        final int n = 4;
        final int[][] edges = {{0,2},{1,3},{1,2}};
        final int expected = -1;
        final int result = FindChampion2.findChampion(n, edges);

        assertEquals(expected, result);
    }
}