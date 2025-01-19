package com.learn.leetcode.daily.a202501.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWater2Test {

    @Test
    void trapRainWater1() {
        final int[][] heightMap = {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        final int expected = 4;
        final int answer = TrappingRainWater2.trapRainWater(heightMap);

        assertEquals(expected, answer);
    }

    @Test
    void trapRainWater2() {
        final int[][] heightMap = {{3,3,3,3,3}, {3,2,2,2,3}, {3,2,1,2,3}, {3,2,2,2,3}, {3,3,3,3,3}};
        final int expected = 10;
        final int answer = TrappingRainWater2.trapRainWater(heightMap);

        assertEquals(expected, answer);
    }
}