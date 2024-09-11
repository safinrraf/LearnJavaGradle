package com.learn.leetcode.daily.q202409;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumBitFlipsToConvertNumberTest {

    @Test
    void minBitFlips1() {
        final var result = MinimumBitFlipsToConvertNumber.minBitFlips(10, 7);

        assertEquals(3, result);
    }

    @Test
    void minBitFlips2() {
        final var result = MinimumBitFlipsToConvertNumber.minBitFlips(3, 4);

        assertEquals(3, result);
    }
}