package com.learn.leetcode.daily.x202412.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxChunksToMakeSortedTest {

    @Test
    void maxChunksToSorted1() {
        final int[] arr = {4,3,2,1,0};
        final int expected = 1;
        final int result = MaxChunksToMakeSorted.maxChunksToSorted(arr);

        assertEquals(expected, result);
    }

    @Test
    void maxChunksToSorted2() {
        final int[] arr = {1,0,2,3,4};
        final int expected = 4;
        final int result = MaxChunksToMakeSorted.maxChunksToSorted(arr);

        assertEquals(expected, result);
    }

    @Test
    void maxChunksToSorted3() {
        final int[] arr = {0};
        final int expected = 1;
        final int result = MaxChunksToMakeSorted.maxChunksToSorted(arr);

        assertEquals(expected, result);
    }

    @Test
    void maxChunksToSorted4() {
        final int[] arr = {0,1};
        final int expected = 2;
        final int result = MaxChunksToMakeSorted.maxChunksToSorted(arr);

        assertEquals(expected, result);
    }
}