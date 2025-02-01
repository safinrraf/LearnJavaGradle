package com.learn.leetcode.daily.q202410.medium;

import com.learn.leetcode.daily.w2024.q202410.medium.CountSquareSubmatricesWithAllOnes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CountSquareSubmatricesWithAllOnesTest {

    @Test
    void countSquares1() {
        final var input = new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        final var expected = 15;
        final var result = CountSquareSubmatricesWithAllOnes.countSquares(input);

        assertEquals(expected, result);
    }

    @Test
    void countSquares2() {
        final var input = new int[][]{
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        final var expected = 7;
        final var result = CountSquareSubmatricesWithAllOnes.countSquares(input);

        assertEquals(expected, result);
    }
}