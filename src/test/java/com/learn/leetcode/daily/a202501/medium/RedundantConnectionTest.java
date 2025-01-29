package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedundantConnectionTest {

    @Test
    void findRedundantConnection1() {
        final int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        final int[] expected = {2,3};
        final int[] answer = RedundantConnection.findRedundantConnection(edges);

        assertArrayEquals(expected, answer);
    }

    @Test
    void findRedundantConnection2() {
        final int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        final int[] expected = {1,4};
        final int[] answer = RedundantConnection.findRedundantConnection(edges);

        assertArrayEquals(expected, answer);
    }
}