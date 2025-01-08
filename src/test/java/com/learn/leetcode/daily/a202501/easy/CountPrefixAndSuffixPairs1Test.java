package com.learn.leetcode.daily.a202501.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CountPrefixAndSuffixPairs1Test {

    @Test
    void countPrefixSuffixPairs1() {
        final String[] words = {"a","aba","ababa","aa"};
        final int expected = 4;
        final int answer = CountPrefixAndSuffixPairs1.countPrefixSuffixPairs(words);

        assertEquals(expected, answer);
    }

    @Test
    void countPrefixSuffixPairs2() {
        final String[] words = {"pa","papa","ma","mama"};
        final int expected = 2;
        final int answer = CountPrefixAndSuffixPairs1.countPrefixSuffixPairs(words);

        assertEquals(expected, answer);
    }

    @Test
    void countPrefixSuffixPairs3() {
        final String[] words = {"abab","ab"};
        final int expected = 0;
        final int answer = CountPrefixAndSuffixPairs1.countPrefixSuffixPairs(words);

        assertEquals(expected, answer);
    }

    @Test
    void countPrefixSuffixPairs4() {
        final String[] words = {"a","ab","abc"};
        final int expected = 0;
        final int answer = CountPrefixAndSuffixPairs1.countPrefixSuffixPairs(words);

        assertEquals(expected, answer);
    }
}