package com.learn.leetcode.daily.x202412.medium;

import com.learn.leetcode.daily.w2024.x202412.medium.ConstructStringWithRepeatLimit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructStringWithRepeatLimitTest {

    @Test
    void repeatLimitedString1() {
        final String s = "cczazcc";
        final int repeatLimit = 3;
        final String expected = "zzcccac";
        final String result = ConstructStringWithRepeatLimit.repeatLimitedString(s, repeatLimit);

        assertEquals(expected, result);
    }

    @Test
    void repeatLimitedString2() {
        final String s = "aababab";
        final int repeatLimit = 2;
        final String expected = "bbabaa";
        final String result = ConstructStringWithRepeatLimit.repeatLimitedString(s, repeatLimit);

        assertEquals(expected, result);
    }

    @Test
    void repeatLimitedString3() {
        final String s = "cczazcc";
        final int repeatLimit = 3;
        final String expected = "zzcccac";
        final String result = ConstructStringWithRepeatLimit.repeatLimitedString2(s, repeatLimit);

        assertEquals(expected, result);
    }

    @Test
    void repeatLimitedString4() {
        final String s = "aababab";
        final int repeatLimit = 2;
        final String expected = "bbabaa";
        final String result = ConstructStringWithRepeatLimit.repeatLimitedString2(s, repeatLimit);

        assertEquals(expected, result);
    }
}