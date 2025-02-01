package com.learn.leetcode.daily.x202412.medium;

import com.learn.leetcode.daily.w2024.x202412.medium.MakeStringSubsequenceUsingCyclicIncrements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MakeStringSubsequenceUsingCyclicIncrementsTest {

    @Test
    void canMakeSubsequence1() {
        final String str1 = "abc";
        final String str2 = "ad";
        final boolean expected = true;
        final boolean result = MakeStringSubsequenceUsingCyclicIncrements.canMakeSubsequence(str1, str2);

        assertEquals(expected, result);
    }

    @Test
    void canMakeSubsequence2() {
        final String str1 = "zc";
        final String str2 = "ad";
        final boolean expected = true;
        final boolean result = MakeStringSubsequenceUsingCyclicIncrements.canMakeSubsequence(str1, str2);

        assertEquals(expected, result);
    }

    @Test
    void canMakeSubsequence3() {
        final String str1 = "ab";
        final String str2 = "d";
        final boolean expected = false;
        final boolean result = MakeStringSubsequenceUsingCyclicIncrements.canMakeSubsequence(str1, str2);

        assertEquals(expected, result);
    }
}