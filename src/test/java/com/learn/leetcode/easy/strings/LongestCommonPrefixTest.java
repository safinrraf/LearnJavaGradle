package com.learn.leetcode.easy.strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix1() {
        final var input = new String[]{"flower","flow","flight"};
        final var expected = "fl";

        final var result = LongestCommonPrefix.longestCommonPrefix(input);

        assertEquals(expected, result);
    }

    @Test
    void longestCommonPrefix2() {
        final var input = new String[]{"dog","racecar","car"};
        final var expected = "";

        final var result = LongestCommonPrefix.longestCommonPrefix(input);

        assertEquals(expected, result);
    }

    @Test
    void longestCommonPrefix3() {
        final var input = new String[]{"a","aa","aaa"};
        final var expected = "a";

        final var result = LongestCommonPrefix.longestCommonPrefix(input);

        assertEquals(expected, result);
    }
}