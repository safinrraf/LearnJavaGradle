package com.learn.leetcode.daily.q202409;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheLongestSubstringContainingVowelsInEvenCountsTest {

    @Test
    void findTheLongestSubstring1() {
        final var input = "eleetminicoworoep";
        final var expected = 13;
        final var result = FindTheLongestSubstringContainingVowelsInEvenCounts.findTheLongestSubstring(input);

        assertEquals(expected, result);
    }

    @Test
    void findTheLongestSubstring2() {
        final var input = "leetcodeisgreat";
        final var expected = 5;
        final var result = FindTheLongestSubstringContainingVowelsInEvenCounts.findTheLongestSubstring(input);

        assertEquals(expected, result);
    }

    @Test
    void findTheLongestSubstring3() {
        final var input = "bcbcbc";
        final var expected = 6;
        final var result = FindTheLongestSubstringContainingVowelsInEvenCounts.findTheLongestSubstring(input);

        assertEquals(expected, result);
    }
}