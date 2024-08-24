package com.learn.leetcode.easy.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplementStrStrTest {

    @Test
    void strStr1() {
        final var haystack = "sadbutsad";
        final var needle = "sad";

        assertEquals(0, ImplementStrStr.strStr(haystack, needle));
    }

    @Test
    void strStr2() {
        final var haystack = "leetcode";
        final var needle = "leeto";

        assertEquals(-1, ImplementStrStr.strStr(haystack, needle));
    }

    @Test
    void strStr3() {
        final var haystack = "a";
        final var needle = "a";

        assertEquals(0, ImplementStrStr.strStr(haystack, needle));
    }

    @Test
    void strStr4() {
        final var haystack = "mississippi";
        final var needle = "pi";

        assertEquals(9, ImplementStrStr.strStr(haystack, needle));
    }
}