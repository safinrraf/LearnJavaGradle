package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.ShortestDistanceAfterRoadAdditionQueries2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code ..., ..., ...}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 27.11.24 08:22
 */
class ShortestDistanceAfterRoadAdditionQueries2Test {

    @Test
    void shortestDistanceAfterQueries1() {
        final int[][] queries = {{2,4},{0,2},{0,4}};
        final int n = 5;
        final int[] expected = {3,2,1};
        final int[] result = ShortestDistanceAfterRoadAdditionQueries2.shortestDistanceAfterQueries(n, queries);

        assertArrayEquals(expected, result);
    }

    @Test
    void shortestDistanceAfterQueries2() {
        final int[][] queries = {{0,3},{0,2}};
        final int n = 4;
        final int[] expected = {1,1};
        final int[] result = ShortestDistanceAfterRoadAdditionQueries2.shortestDistanceAfterQueries(n, queries);

        assertArrayEquals(expected, result);
    }
}