package com.learn.leetcode.daily.q202410;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CountNumberOfMaximumBitwiseOrSubsetsTest {

    @Test
    void countMaxOrSubsets1() {
        final var input = new int[]{3,1};
        final var expected = 2;
        final var result = CountNumberOfMaximumBitwiseOrSubsets.countMaxOrSubsets(input);

        assertEquals(expected, result);
    }

    @Test
    void countMaxOrSubsets2() {
        final var input = new int[]{2,2,2};
        final var expected = 7;
        final var result = CountNumberOfMaximumBitwiseOrSubsets.countMaxOrSubsets(input);

        assertEquals(expected, result);
    }

    @Test
    void countMaxOrSubsets3() {
        final var input = new int[]{3,2,1,5};
        final var expected = 6;
        final var result = CountNumberOfMaximumBitwiseOrSubsets.countMaxOrSubsets(input);

        assertEquals(expected, result);
    }
}