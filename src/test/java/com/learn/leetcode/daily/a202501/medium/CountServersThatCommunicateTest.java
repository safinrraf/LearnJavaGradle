package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountServersThatCommunicateTest {

    @Test
    void countServers1() {
        final int[][] grid = {{1, 0}, {0, 1}};
        final int expected = 0;
        final int answer = CountServersThatCommunicate.countServers(grid);

        assertEquals(expected, answer);
    }

    @Test
    void countServers2() {
        final int[][] grid = {{1, 0}, {1, 1}};
        final int expected = 3;
        final int answer = CountServersThatCommunicate.countServers(grid);

        assertEquals(expected, answer);
    }

    @Test
    void countServers3() {
        final int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        final int expected = 4;
        final int answer = CountServersThatCommunicate.countServers(grid);

        assertEquals(expected, answer);
    }

    @Test
    void countServers11() {
        final int[][] grid = {{1, 0}, {0, 1}};
        final int expected = 0;
        final int answer = CountServersThatCommunicate.countServers_1(grid);

        assertEquals(expected, answer);
    }

    @Test
    void countServers12() {
        final int[][] grid = {{1, 0}, {1, 1}};
        final int expected = 3;
        final int answer = CountServersThatCommunicate.countServers_1(grid);

        assertEquals(expected, answer);
    }

    @Test
    void countServers13() {
        final int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        final int expected = 4;
        final int answer = CountServersThatCommunicate.countServers_1(grid);

        assertEquals(expected, answer);
    }
}