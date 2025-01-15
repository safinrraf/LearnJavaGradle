package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MinimizeXORTest {

    @Test
    void minimizeXor1() {
        final int num1 = 3;
        final int num2 = 5;
        final int expected = 3;
        final int answer = MinimizeXOR.minimizeXor(num1, num2);

        assertEquals(expected, answer);
    }

    @Test
    void minimizeXor2() {
        final int num1 = 1;
        final int num2 = 12;
        final int expected = 3;
        final int answer = MinimizeXOR.minimizeXor(num1, num2);

        assertEquals(expected, answer);
    }
}