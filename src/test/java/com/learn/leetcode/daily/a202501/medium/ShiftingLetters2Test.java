package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShiftingLetters2Test {

    @Test
    void shiftingLetters1() {
        final String s = "abc";
        final int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        final String expected = "ace";
        final String result = ShiftingLetters2.shiftingLetters(s, shifts);

        assertEquals(expected, result);
    }

    @Test
    void shiftingLetters2() {
        final String s = "dztz";
        final int[][] shifts = {{0, 0, 0}, {1, 1, 1}};
        final String expected = "catz";
        final String result = ShiftingLetters2.shiftingLetters(s, shifts);

        assertEquals(expected, result);
    }
}