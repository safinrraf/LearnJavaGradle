package com.learn.leetcode.daily.a202501.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingWordsWithGivenPrefixTest {

    @Test
    void prefixCount1() {
        final String[] words = {"pay","attention","practice","attend"};
        final String pref = "at";
        final int expected = 2;
        final int answer = CountingWordsWithGivenPrefix.prefixCount(words, pref);

        assertEquals(expected, answer);
    }

    @Test
    void prefixCount2() {
        final String[] words = {"leetcode","win","loops","success"};
        final String pref = "code";
        final int expected = 0;
        final int answer = CountingWordsWithGivenPrefix.prefixCount(words, pref);

        assertEquals(expected, answer);
    }

    @Test
    void prefixCount3() {
        final String[] words = {"a","a","b","a"};
        final String pref = "code";
        final int expected = 0;
        final int answer = CountingWordsWithGivenPrefix.prefixCount(words, pref);

        assertEquals(expected, answer);
    }

    @Test
    void prefixCount4() {
        final String[] words = {"a"};
        final String pref = "a";
        final int expected = 1;
        final int answer = CountingWordsWithGivenPrefix.prefixCount(words, pref);

        assertEquals(expected, answer);
    }
}