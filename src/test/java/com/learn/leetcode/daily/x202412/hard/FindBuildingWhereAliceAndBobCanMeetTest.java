package com.learn.leetcode.daily.x202412.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class FindBuildingWhereAliceAndBobCanMeetTest {

    @Test
    void leftmostBuildingQueries_PQ1() {
        final int[] heights = {6,4,8,5,2,7};
        final int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        final int[] expected = {2,5,-1,5,2};
        final int[] result = FindBuildingWhereAliceAndBobCanMeet.leftmostBuildingQueries_PQ(heights, queries);

        assertArrayEquals(expected, result);
    }

    @Test
    void leftmostBuildingQueries_PQ2() {
        final int[] heights = {5,3,8,2,6,1,4,6};
        final int[][] queries = {{0, 7}, {3, 5}, {5, 2}, {3, 0}, {1, 6}};
        final int[] expected = {7,6,-1,4,6};
        final int[] result = FindBuildingWhereAliceAndBobCanMeet.leftmostBuildingQueries_PQ(heights, queries);

        assertArrayEquals(expected, result);
    }
}