package com.learn.leetcode.daily.x202412.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumNumberOfKDivisibleComponentsTest {

    @Test
    void maxKDivisibleComponents1() {
        final int n = 5;
        final int[][] edges = {{0, 2},{1, 2},{1, 3},{2, 4}};
        final int[] values = {1,8,1,4,4};
        final int k = 6;

        final int result = MaximumNumberOfKDivisibleComponents.maxKDivisibleComponents(n, edges, values, k);
        final int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    void maxKDivisibleComponents2() {
        final int n = 7;
        final int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        final int[] values = {3,0,6,1,5,2,1};
        final int k = 3;

        final int result = MaximumNumberOfKDivisibleComponents.maxKDivisibleComponents(n, edges, values, k);
        final int expected = 3;

        assertEquals(expected, result);
    }

    @Test
    void maxKDivisibleComponents3() {
        final int n = 5;
        final int[][] edges = {{0, 2},{1, 2},{1, 3},{2, 4}};
        final int[] values = {1,8,1,4,4};
        final int k = 6;

        final int result = MaximumNumberOfKDivisibleComponents.maxKDivisibleComponents_BFS(n, edges, values, k);
        final int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    void maxKDivisibleComponents4() {
        final int n = 7;
        final int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        final int[] values = {3,0,6,1,5,2,1};
        final int k = 3;

        final int result = MaximumNumberOfKDivisibleComponents.maxKDivisibleComponents_BFS(n, edges, values, k);
        final int expected = 3;

        assertEquals(expected, result);
    }

    @Test
    void maxKDivisibleComponents5() {
        final int n = 5;
        final int[][] edges = {{0, 2},{1, 2},{1, 3},{2, 4}};
        final int[] values = {1,8,1,4,4};
        final int k = 6;

        final int result = MaximumNumberOfKDivisibleComponents.maxKDivisibleComponents_Topological_Sort__Onion_Sort(n, edges, values, k);
        final int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    void maxKDivisibleComponents6() {
        final int n = 7;
        final int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        final int[] values = {3,0,6,1,5,2,1};
        final int k = 3;

        final int result = MaximumNumberOfKDivisibleComponents.maxKDivisibleComponents_Topological_Sort__Onion_Sort(n, edges, values, k);
        final int expected = 3;

        assertEquals(expected, result);
    }
}