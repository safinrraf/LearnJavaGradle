package com.learn.leetcode.daily.q202410;

import com.learn.leetcode.daily.w2024.q202410.medium.LongestHappyString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestHappyStringTest {

    @Test
    void longestDiverseString1() {
        final var a = 1;
        final var b = 1;
        final var c = 7;
        final var expected = "ccaccbcc";
        final var result = LongestHappyString.longestDiverseString(a, b, c);

        assertEquals(expected, result);
    }

    @Test
    void longestDiverseString2() {
        final var a = 7;
        final var b = 1;
        final var c = 0;
        final var expected = "aabaa";
        final var result = LongestHappyString.longestDiverseString(a, b, c);

        assertEquals(expected, result);
    }
}