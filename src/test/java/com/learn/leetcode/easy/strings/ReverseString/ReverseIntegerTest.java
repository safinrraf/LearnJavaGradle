package com.learn.leetcode.easy.strings;

import com.learn.leetcode.easy.strings.ReverseInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    @Test
    void reverse1() {
        final var input = 123456;
        final var expected = 654321;

        final var result = ReverseInteger.reverse(input);

        assertEquals(expected, result);
    }

    @Test
    void reverse2() {
        final var input = 0;
        final var expected = 0;

        final var result = ReverseInteger.reverse(input);

        assertEquals(expected, result);
    }

    @Test
    void reverse3() {
        final var input = 12;
        final var expected = 21;

        final var result = ReverseInteger.reverse(input);

        assertEquals(expected, result);
    }

    @Test
    void reverse4() {
        final var input = 3;
        final var expected = 3;

        final var result = ReverseInteger.reverse(input);

        assertEquals(expected, result);
    }

    @Test
    void reverse5() {
        final var input = -3456;
        final var expected = -6543;

        final var result = ReverseInteger.reverse(input);

        assertEquals(expected, result);
    }

    @Test
    void reverse6() {
        final var input = 1534236469;
        final var expected = 0;

        final var result = ReverseInteger.reverse(input);

        assertEquals(expected, result);
    }
}