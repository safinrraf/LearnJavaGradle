package com.learn.leetcode.daily.q202409;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XORQueriesOfASubarrayTest {

    @Test
    void xorQueries1() {
        final var arr = new int[]{1,3,4,8};
        final var queries = new int[][]{{0,1},{1,2},{0,3},{3,3}};
        final var expected = new int[]{2,7,14,8};
        final var result = XORQueriesOfASubarray.xorQueries(arr, queries);

        assertArrayEquals(expected, result);
    }
}