package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueLength3PalindromicSubsequencesTest {

    @Test
    void countPalindromicSubsequence1() {
        final String s = "aabca";
        final int expected = 3;
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }

    @Test
    void countPalindromicSubsequence2() {
        final String s = "adc";
        final int expected = 0;
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }

    @Test
    void countPalindromicSubsequence3() {
        final String s = "bbcbaba";
        final int expected = 4;
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }

    @Test
    void countPalindromicSubsequence4() {
        final String s = "aaa";
        final int expected = 1;
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }

    @Test
    void countPalindromicSubsequence5() {
        final String s = "aaaa";
        final int expected = 1; //unique palindromes
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }

    @Test
    void countPalindromicSubsequence6() {
        final String s = "aaaaa";
        final int expected = 1; //unique palindromes
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }

    @Test
    void countPalindromicSubsequence7() {
        final String s = "aaaaaa";
        final int expected = 1; //unique palindromes
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }

    @Test
    void countPalindromicSubsequence8() {
        final String s = "aaaaaaa";
        final int expected = 1; //unique palindromes
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }

    @Test
    void countPalindromicSubsequence9() {
        final String s = "abcdaa";
        final int expected = 4; //unique palindromes
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }

    @Test
    void countPalindromicSubsequence90() {
        final String s = "cbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbc" +
                "bcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcb" +
                "cbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcc" +
                "bcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbc" +
                "bccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcb" +
                "cbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbc" +
                "bcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcb" +
                "cbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbc" +
                "bcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcb" +
                "cbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbc" +
                "bcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcb" +
                "cbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbc" +
                "bcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcb" +
                "cbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbc" +
                "bcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbc" +
                "cbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcb" +
                "cbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbc" +
                "bcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcb" +
                "cbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbc" +
                "bcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcb" +
                "cbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbc" +
                "bcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcb" +
                "cbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbc" +
                "bcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcb" +
                "cbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbcbccbcbc" +
                "bcbcbcbcbcbcbcbcbcbcbcbcbcbcbccb";
        final int expected = 4;
        final int result = UniqueLength3PalindromicSubsequences.countPalindromicSubsequence(s);

        assertEquals(expected, result);
    }
}