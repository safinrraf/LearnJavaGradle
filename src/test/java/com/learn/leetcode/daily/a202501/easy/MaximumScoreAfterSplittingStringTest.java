package com.learn.leetcode.daily.a202501.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumScoreAfterSplittingStringTest {

    @Test
    void maxScore1() {
        final String s = "011101";
        final int expected = 5;
        final int result = MaximumScoreAfterSplittingString.maxScore(s);

        assertEquals(expected, result);
    }

    @Test
    void maxScore2() {
        final String s = "00111";
        final int expected = 5;
        final int result = MaximumScoreAfterSplittingString.maxScore(s);

        assertEquals(expected, result);
    }

    @Test
    void maxScore3() {
        final String s = "1111";
        final int expected = 3;
        final int result = MaximumScoreAfterSplittingString.maxScore(s);

        assertEquals(expected, result);
    }

    @Test
    void maxScore4() {
        final String s = "0000";
        final int expected = 3;
        final int result = MaximumScoreAfterSplittingString.maxScore(s);

        assertEquals(expected, result);
    }

    @Test
    void maxScore5() {
        final String s = "10";
        final int expected = 0;
        final int result = MaximumScoreAfterSplittingString.maxScore(s);

        assertEquals(expected, result);
    }

    @Test
    void maxScore6() {
        final String s = "01";
        final int expected = 2;
        final int result = MaximumScoreAfterSplittingString.maxScore(s);

        assertEquals(expected, result);
    }
}