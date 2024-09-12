package com.learn.leetcode.daily.q202409;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountTheNumberOfConsistentStringsTest {

    @Test
    void countConsistentStrings1() {
        final var allowed = "ab";
        final var words = new String[]{"ad","bd","aaab","baa","badab"};

        assertEquals(2, CountTheNumberOfConsistentStrings.countConsistentStrings(allowed, words));
    }

    @Test
    void countConsistentStrings2() {
        final var allowed = "abc";
        final var words = new String[]{"a","b","c","ab","ac","bc","abc"};

        assertEquals(7, CountTheNumberOfConsistentStrings.countConsistentStrings(allowed, words));
    }

    @Test
    void countConsistentStrings3() {
        final var allowed = "cad";
        final var words = new String[]{"cc","acd","b","ba","bac","bad","ac","d"};

        assertEquals(4, CountTheNumberOfConsistentStrings.countConsistentStrings(allowed, words));
    }
}