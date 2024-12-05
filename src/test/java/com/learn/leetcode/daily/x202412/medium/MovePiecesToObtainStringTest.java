package com.learn.leetcode.daily.x202412.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code ..., ..., ...}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 05.12.24 11:17
 */
class MovePiecesToObtainStringTest {

    @Test
    void canChange1() {
        final String start = "_L__R__R_";
        final String target = "L______RR";
        final boolean expected = true;
        final boolean result = MovePiecesToObtainString.canChange(start, target);

        assertEquals(expected, result);
    }

    @Test
    void canChange2() {
        final String start = "R_L_";
        final String target = "__LR";
        final boolean expected = false;
        final boolean result = MovePiecesToObtainString.canChange(start, target);

        assertEquals(expected, result);
    }

    @Test
    void canChange3() {
        final String start = "_R";
        final String target = "R_";
        final boolean expected = false;
        final boolean result = MovePiecesToObtainString.canChange(start, target);

        assertEquals(expected, result);
    }
}