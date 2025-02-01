package com.learn.leetcode.daily.u202411.easy;

import com.learn.leetcode.daily.w2024.u202411.easy.RotateString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateStringTest {

    @Test
    void rotateString1() {
        var s = "abcde";
        var goal = "cdeab";

        assertTrue(RotateString.rotateString(s, goal));
    }

    @Test
    void rotateString2() {
        var s = "abcde";
        var goal = "abced";

        assertFalse(RotateString.rotateString(s, goal));
    }

    @Test
    void rotateString3() {
        var s = "bbbacddceeb";
        var goal = "ceebbbbacdd";

        assertTrue(RotateString.rotateString(s, goal));
    }

    @Test
    void rotateString4() {
        var s = "a";
        var goal = "a";

        assertTrue(RotateString.rotateString(s, goal));
    }

    @Test
    void rotateString5() {
        var s = "abcdebcdefin";
        var goal = "abcdebcdefin";

        assertTrue(RotateString.rotateString(s, goal));
    }
}