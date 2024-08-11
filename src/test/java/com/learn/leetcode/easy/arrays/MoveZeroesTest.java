package com.learn.leetcode.easy.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveZeroesTest {

    @Test
    void moveZeroes1() {
        final var input = new int[]{0,1,0,3,12};
        final var expected = new int[]{1,3,12,0,0};

        MoveZeroes.moveZeroes(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes2() {
        final var input = new int[]{0};
        final var expected = new int[]{0};

        MoveZeroes.moveZeroes(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes3() {
        final var input = new int[]{1,2,3,0,0};
        final var expected = new int[]{1,2,3,0,0};

        MoveZeroes.moveZeroes(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes4() {
        final var input = new int[]{1,0,2,0,3,0,4,0};
        final var expected = new int[]{1,2,3,4,0,0,0,0};

        MoveZeroes.moveZeroes(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes5() {
        final var input = new int[]{0,0,0,0,3,4};
        final var expected = new int[]{3,4,0,0,0,0};

        MoveZeroes.moveZeroes(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes6() {
        final var input = new int[]{0,1};
        final var expected = new int[]{1,0};

        MoveZeroes.moveZeroes(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes7() {
        final var input = new int[]{0,0,1};
        final var expected = new int[]{1,0,0};

        MoveZeroes.moveZeroes(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes8() {
        final var input = new int[]{0,0,1,0,-1,-2,0};
        final var expected = new int[]{1,-1,-2,0,0,0,0};

        MoveZeroes.moveZeroes(input);

        assertArrayEquals(expected, input);
    }
}