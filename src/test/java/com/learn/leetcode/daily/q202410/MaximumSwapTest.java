package com.learn.leetcode.daily.q202410;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSwapTest {

    @Test
    void maximumSwap1() {
        final var input = 2736;
        final var expected = 7236;
        final var result = MaximumSwap.maximumSwap(input);

        assertEquals(expected, result);
    }

    @Test
    void maximumSwap2() {
        final var input = 9973;
        final var expected = 9973;
        final var result = MaximumSwap.maximumSwap(input);

        assertEquals(expected, result);
    }
}