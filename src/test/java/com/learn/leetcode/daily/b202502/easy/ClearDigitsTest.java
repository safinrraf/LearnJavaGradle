package com.learn.leetcode.daily.b202502.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClearDigitsTest {

    @Test
    void clearDigits1() {
        final String s = "abc";
        final String expected = "abc";
        final String answer = ClearDigits.clearDigits(s);

        assertEquals(expected, answer);
    }

    @Test
    void clearDigits2() {
        final String s = "cb34";
        final String expected = "";
        final String answer = ClearDigits.clearDigits(s);

        assertEquals(expected, answer);
    }

    @Test
    void clearDigits3() {
        final String s = "acb34";
        final String expected = "a";
        final String answer = ClearDigits.clearDigits(s);

        assertEquals(expected, answer);
    }

    @Test
    void clearDigits4() {
        final String s = "acb34";
        final String expected = "a";
        final String answer = ClearDigits.clearDigits(s);

        assertEquals(expected, answer);
    }

    @Test
    void clearDigits5() {
        final String s = "q";
        final String expected = "q";
        final String answer = ClearDigits.clearDigits(s);

        assertEquals(expected, answer);
    }

    @Test
    void clearDigits6() {
        final String s = "q1w1e1q1w1q1we1";
        final String expected = "w";
        final String answer = ClearDigits.clearDigits(s);

        assertEquals(expected, answer);
    }

    @Test
    void clearDigits7() {
        final String s = "du0s";
        final String expected = "ds";
        final String answer = ClearDigits.clearDigits(s);

        assertEquals(expected, answer);
    }

    @Test
    void clearDigits8() {
        final String s = "uwj14x";
        final String expected = "ux";
        final String answer = ClearDigits.clearDigits(s);

        assertEquals(expected, answer);
    }
}