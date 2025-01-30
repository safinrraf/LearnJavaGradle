package com.learn.leetcode.daily.a202501.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideNodesIntoTheMaximumNumberOfGroupsTest {

    @Test
    void magnificentSets1() {
        final int n = 6;
        final int[][] edges = {{1, 2}, {1, 4}, {1, 5}, {2, 6}, {2, 3}, {4, 6}};
        final int expected = 4;
        final int answer = DivideNodesIntoTheMaximumNumberOfGroups.magnificentSets(n, edges);

        assertEquals(expected, answer);
    }

    @Test
    void magnificentSets2() {
        final int n = 3;
        final int[][] edges = {{1, 2}, {2, 3}, {3, 1}};
        final int expected = -1;
        final int answer = DivideNodesIntoTheMaximumNumberOfGroups.magnificentSets(n, edges);

        assertEquals(expected, answer);
    }
}