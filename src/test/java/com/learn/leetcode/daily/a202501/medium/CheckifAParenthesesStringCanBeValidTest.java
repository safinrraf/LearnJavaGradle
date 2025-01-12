package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckifAParenthesesStringCanBeValidTest {

    @Test
    void canBeValid1() {
        final String s = "))()))";
        final String locked = "010100";

        assertTrue(CheckifAParenthesesStringCanBeValid.canBeValid(s, locked));
    }

    @Test
    void canBeValid2() {
        final String s = "()()";
        final String locked = "0000";

        assertTrue(CheckifAParenthesesStringCanBeValid.canBeValid(s, locked));
    }

    @Test
    void canBeValid3() {
        final String s = ")";
        final String locked = "0";

        assertFalse(CheckifAParenthesesStringCanBeValid.canBeValid(s, locked));
    }
}