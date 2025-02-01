package com.learn.leetcode.daily.q202409;

import com.learn.leetcode.daily.w2024.q202409.MinimumBitFlipsToConvertNumber;
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