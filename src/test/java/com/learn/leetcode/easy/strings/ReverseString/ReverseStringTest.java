package com.learn.leetcode.easy.strings.ReverseString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void reverseString1() {
        final var input = new char[]{'h','e','l','l','o'};
        final var expected = new char[]{'o','l','l','e','h'};

        ReverseString.reverseString(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void reverseString2() {
        final var input = new char[]{'H','a','n','n','a','h'};
        final var expected = new char[]{'h','a','n','n','a','H'};

        ReverseString.reverseString(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void reverseString3() {
        final var input = new char[]{'H'};
        final var expected = new char[]{'H'};

        ReverseString.reverseString(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void reverseString4() {
        final var input = new char[]{'1','0'};
        final var expected = new char[]{'0','1'};

        ReverseString.reverseString(input);

        assertArrayEquals(expected, input);
    }
}