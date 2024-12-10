package com.learn.leetcode.daily.x202412.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindLongestSpecialSubstringThatOccursThrice1Test {
    @Test
    void maximumLength1() {
        final String s = "aaaa";
        final int expected = 2;
        final int result = FindLongestSpecialSubstringThatOccursThrice1.maximumLength(s);

        assertEquals(expected, result);
    }

    @Test
    void maximumLength2() {
        final String s = "abcdef";
        final int expected = -1;
        final int result = FindLongestSpecialSubstringThatOccursThrice1.maximumLength(s);

        assertEquals(expected, result);
    }

    @Test
    void maximumLength3() {
        final String s = "abcaba";
        final int expected = 1;
        final int result = FindLongestSpecialSubstringThatOccursThrice1.maximumLength(s);

        assertEquals(expected, result);
    }

    @Test
    void maximumLength4() {
        final String s = "abcaabcaabcaabca";
        final int expected = 2;
        final int result = FindLongestSpecialSubstringThatOccursThrice1.maximumLength(s);

        assertEquals(expected, result);
    }

    @Test
    void maximumLength5() {
        final String s = "wwwwwwwwwwww";
        final int expected = 10;
        final int result = FindLongestSpecialSubstringThatOccursThrice1.maximumLength(s);

        assertEquals(expected, result);
    }
}