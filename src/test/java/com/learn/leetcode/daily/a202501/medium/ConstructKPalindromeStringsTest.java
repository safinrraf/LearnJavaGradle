package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructKPalindromeStringsTest {

    @Test
    void canConstruct1() {
        final String s = "annabelle";
        final int k = 2;

        assertTrue(ConstructKPalindromeStrings.canConstruct(s, k));
    }

    @Test
    void canConstruct2() {
        final String s = "leetcode";
        final int k = 3;

        assertFalse(ConstructKPalindromeStrings.canConstruct(s, k));
    }

    @Test
    void canConstruct3() {
        final String s = "true";
        final int k = 4;

        assertTrue(ConstructKPalindromeStrings.canConstruct(s, k));
    }

    @Test
    void canConstruct4() {
        final String s = "w";
        final int k = 4;

        assertFalse(ConstructKPalindromeStrings.canConstruct(s, k));
    }

    @Test
    void canConstruct5() {
        final String s = "w";
        final int k = 1;

        assertTrue(ConstructKPalindromeStrings.canConstruct(s, k));
    }
}