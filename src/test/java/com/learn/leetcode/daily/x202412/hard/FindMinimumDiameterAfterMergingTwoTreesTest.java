package com.learn.leetcode.daily.x202412.hard;

import com.learn.leetcode.daily.w2024.x202412.hard.FindMinimumDiameterAfterMergingTwoTrees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumDiameterAfterMergingTwoTreesTest {

    @Test
    void minimumDiameterAfterMerge1() {
        final int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}};
        final int[][] edges2 = {{0, 1}};
        final int expected = 3;
        final int result = FindMinimumDiameterAfterMergingTwoTrees.minimumDiameterAfterMerge(edges1, edges2);

        assertEquals(expected, result);
    }

    @Test
    void minimumDiameterAfterMerge2() {
        final int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}};
        final int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}};
        final int expected = 5;
        final int result = FindMinimumDiameterAfterMergingTwoTrees.minimumDiameterAfterMerge(edges1, edges2);

        assertEquals(expected, result);
    }
}