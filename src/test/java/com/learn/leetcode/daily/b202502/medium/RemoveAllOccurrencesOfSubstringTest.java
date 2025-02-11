package com.learn.leetcode.daily.b202502.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveAllOccurrencesOfSubstringTest {

    @Test
    void removeOccurrences1() {
        final String s = "daabcbaabcbc";
        final String part = "abc";
        final String expected = "dab";
        final String answer = RemoveAllOccurrencesOfSubstring.removeOccurrences(s, part);

        assertEquals(expected, answer);
    }

    @Test
    void removeOccurrences2() {
        final String s = "axxxxyyyyb";
        final String part = "xy";
        final String expected = "ab";
        final String answer = RemoveAllOccurrencesOfSubstring.removeOccurrences(s, part);

        assertEquals(expected, answer);
    }
}