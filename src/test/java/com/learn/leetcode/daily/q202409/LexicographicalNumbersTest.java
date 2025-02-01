package com.learn.leetcode.daily.q202409;

import com.learn.leetcode.daily.w2024.q202409.LexicographicalNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexicographicalNumbersTest {

    @Test
    void lexicalOrder1() {
        final var n = 13;
        final var expected = List.of(1,10,11,12,13,2,3,4,5,6,7,8,9);
        final var result = LexicographicalNumbers.lexicalOrder(n);

        assertEquals(expected, result);
    }

    @Test
    void lexicalOrder2() {
        final var n = 2;
        final var expected = List.of(1,2);
        final var result = LexicographicalNumbers.lexicalOrder(n);

        assertEquals(expected, result);
    }
}