package com.learn.leetcode.daily.q202410;

import com.learn.leetcode.daily.w2024.q202410.medium.MinimumAddToMakeParenthesesValid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MinimumAddToMakeParenthesesValidTest {

    @Test
    void minAddToMakeValid1() {
        final var input = "())";
        final var expected = 1;
        final var result = MinimumAddToMakeParenthesesValid.minAddToMakeValid(input);

        assertEquals(expected, result);
    }

    @Test
    void minAddToMakeValid2() {
        final var input = "(((";
        final var expected = 3;
        final var result = MinimumAddToMakeParenthesesValid.minAddToMakeValid(input);

        assertEquals(expected, result);
    }
}