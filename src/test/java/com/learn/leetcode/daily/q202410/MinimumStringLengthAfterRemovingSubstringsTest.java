package com.learn.leetcode.daily.q202410;

import com.learn.leetcode.daily.q202410.easy.MinimumStringLengthAfterRemovingSubstrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumStringLengthAfterRemovingSubstringsTest {

    @Test
    void minLength1() {
        final var input = "ABFCACDB";
        final var result = MinimumStringLengthAfterRemovingSubstrings.minLength(input);

        assertEquals(2, result);
    }

    @Test
    void minLength2() {
        final var input = "ACBBD";
        final var result = MinimumStringLengthAfterRemovingSubstrings.minLength(input);

        assertEquals(5, result);
    }

    @Test
    void minLength3() {
        final var input = "GAABBK";
        final var result = MinimumStringLengthAfterRemovingSubstrings.minLength(input);

        assertEquals(2, result);
    }

    @Test
    void minLength4() {
        final var input = "CCCDDD";
        final var result = MinimumStringLengthAfterRemovingSubstrings.minLength(input);

        assertEquals(0, result);
    }
}