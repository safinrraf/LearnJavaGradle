package com.learn.leetcode.daily.q202409;

import com.learn.leetcode.daily.w2024.q202409.KthSmallestInLexicographicalOrder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestInLexicographicalOrderTest {

    @Test
    void findKthNumber1() {
        final var n = 13;
        final var k = 2;
        final var expected = 10;
        final var result = KthSmallestInLexicographicalOrder.findKthNumber(n, k);

        assertEquals(expected, result);
    }

    @Test
    void findKthNumber2() {
        final var n = 804289384;
        final var k = 42641503;
        final var expected = 138377349;
        final var result = KthSmallestInLexicographicalOrder.findKthNumber(n, k);

        assertEquals(expected, result);
    }

    @Test
    void findKthNumber3() {
        final var n = 1;
        final var k = 1;
        final var expected = 1;
        final var result = KthSmallestInLexicographicalOrder.findKthNumber(n, k);

        assertEquals(expected, result);
    }

    @Test
    void findKthNumber4() {
        final var n = 681692778;
        final var k = 351251360;
        final var expected = 416126219;
        final var result = KthSmallestInLexicographicalOrder.findKthNumber(n, k);

        assertEquals(expected, result);
    }
}