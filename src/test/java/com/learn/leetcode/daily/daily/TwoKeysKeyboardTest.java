package com.learn.leetcode.daily.daily;

import com.learn.leetcode.daily.q202408.TwoKeysKeyboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoKeysKeyboardTest {

    @Test
    void minSteps1() {
        final var input = 1;
        final var expected = 0;
        final var result = TwoKeysKeyboard.minSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minSteps3() {
        final var input = 3;
        final var expected = 3;
        final var result = TwoKeysKeyboard.minSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minSteps4() {
        final var input = 4;
        final var expected = 4;
        final var result = TwoKeysKeyboard.minSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minSteps5() {
        final var input = 5;
        final var expected = 5;
        final var result = TwoKeysKeyboard.minSteps(input);

        assertEquals(expected, result);
    }

    @Test
    void minSteps6() {
        final var input = 6;
        final var expected = 5;
        final var result = TwoKeysKeyboard.minSteps(input);

        assertEquals(expected, result);
    }
}