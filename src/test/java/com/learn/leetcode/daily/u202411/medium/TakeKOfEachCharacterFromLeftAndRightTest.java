package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.TakeKOfEachCharacterFromLeftAndRight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TakeKOfEachCharacterFromLeftAndRightTest {

    @Test
    void takeCharacters1() {
        final var s = "aabaaaacaabc";
        final var k = 2;
        final var expected = 8;
        final var result = TakeKOfEachCharacterFromLeftAndRight.takeCharacters(s, k);

        assertEquals(expected, result);
    }

    @Test
    void takeCharacters2() {
        final var s = "a";
        final var k = 1;
        final var expected = -1;
        final var result = TakeKOfEachCharacterFromLeftAndRight.takeCharacters(s, k);

        assertEquals(expected, result);
    }

    @Test
    void takeCharacters3() {
        final var s = "abc";
        final var k = 1;
        final var expected = 3;
        final var result = TakeKOfEachCharacterFromLeftAndRight.takeCharacters(s, k);

        assertEquals(expected, result);
    }

    @Test
    void takeCharacters4() {
        final var s = "cabc";
        final var k = 1;
        final var expected = 3;
        final var result = TakeKOfEachCharacterFromLeftAndRight.takeCharacters(s, k);

        assertEquals(expected, result);
    }
}