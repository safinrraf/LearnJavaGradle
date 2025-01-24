package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindEventualSafeStatesTest {

    @Test
    void eventualSafeNodes1() {
        final int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        final List<Integer> expected = List.of(2,4,5,6);
        final List<Integer> answer = FindEventualSafeStates.eventualSafeNodes(graph);

        assertEquals(expected, answer);
    }

    @Test
    void eventualSafeNodes2() {
        final int[][] graph = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        final List<Integer> expected = List.of(4);
        final List<Integer> answer = FindEventualSafeStates.eventualSafeNodes(graph);

        assertEquals(expected, answer);
    }

    @Test
    void eventualSafeNodes11() {
        final int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        final List<Integer> expected = List.of(2,4,5,6);
        final List<Integer> answer = FindEventualSafeStates.eventualSafeNodes_DFS(graph);

        assertEquals(expected, answer);
    }

    @Test
    void eventualSafeNodes21() {
        final int[][] graph = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        final List<Integer> expected = List.of(4);
        final List<Integer> answer = FindEventualSafeStates.eventualSafeNodes_DFS(graph);

        assertEquals(expected, answer);
    }
}