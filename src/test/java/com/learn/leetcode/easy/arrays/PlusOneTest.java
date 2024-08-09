package com.learn.leetcode.easy.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    @Test
    void plusOne1() {
        final var input = new int[]{1,2,3};
        final var expected = new int[]{1,2,4};

        assertArrayEquals(expected, PlusOne.plusOne(input));
    }

    @Test
    void plusOne2() {
        final var input = new int[]{4,3,2,1};
        final var expected = new int[]{4,3,2,2};

        assertArrayEquals(expected, PlusOne.plusOne(input));
    }

    @Test
    void plusOne3() {
        final var input = new int[]{4,3,2,1,9,9,9,9,9};
        final var expected = new int[]{4,3,2,2,0,0,0,0,0};

        assertArrayEquals(expected, PlusOne.plusOne(input));
    }

    @Test
    void plusOne4() {
        final var input = new int[]{8,9,9,9,9,9,9,9,9};
        final var expected = new int[]{9,0,0,0,0,0,0,0,0};

        assertArrayEquals(expected, PlusOne.plusOne(input));
    }

    @Test
    void plusOne5() {
        final var input = new int[]{9};
        final var expected = new int[]{1,0};

        assertArrayEquals(expected, PlusOne.plusOne(input));
    }

    @Test
    void plusOne6() {
        final var input = new int[]{9,9,9,9,9};
        final var expected = new int[]{1,0,0,0,0,0};

        assertArrayEquals(expected, PlusOne.plusOne(input));
    }

    @Test
    void plusOne7() {
        final var input = new int[]{1,9,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        final var expected = new int[]{1,9,9,9,9,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};

        assertArrayEquals(expected, PlusOne.plusOne(input));
    }
}