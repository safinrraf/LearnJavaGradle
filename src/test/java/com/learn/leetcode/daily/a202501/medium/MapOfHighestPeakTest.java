package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapOfHighestPeakTest {

    @Test
    void highestPeak1() {
        final int[][] isWater = {{0, 1}, {0, 0}};
        final int[][] expected = {{1, 0}, {2, 1}};
        final int[][] answer = MapOfHighestPeak.highestPeak(isWater);

        for(int i = 0; i < answer.length; i++) {
            assertArrayEquals(expected[i], answer[i]);
        }
    }

    @Test
    void highestPeak2() {
        final int[][] isWater = {{0, 0, 1}, {1, 0, 0}, {0, 0, 0}};
        final int[][] expected = {{1, 1, 0}, {0, 1, 1}, {1, 2, 2}};
        final int[][] answer = MapOfHighestPeak.highestPeak(isWater);

        for(int i = 0; i < answer.length; i++) {
            assertArrayEquals(expected[i], answer[i]);
        }
    }
}