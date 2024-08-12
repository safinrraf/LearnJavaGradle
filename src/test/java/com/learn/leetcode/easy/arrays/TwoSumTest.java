package com.learn.leetcode.easy.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSum1() {
        final var input = new int[]{2,7,11,15};
        final var sum = 9;
        final var expected = new int[]{0, 1};

        assertArrayEquals(expected, TwoSum.twoSum(input, sum));
    }

    @Test
    void twoSum2() {
        final var input = new int[]{3,2,4};
        final var sum = 6;
        final var expected = new int[]{1,2};

        assertArrayEquals(expected, TwoSum.twoSum(input, sum));
    }

    @Test
    void twoSum3() {
        final var input = new int[]{3,3};
        final var sum = 6;
        final var expected = new int[]{0,1};

        assertArrayEquals(expected, TwoSum.twoSumNotMy(input, sum));
    }

    @Test
    void twoSum4() {
        final var input = new int[]{3,3,1,2};
        final var sum = 6;
        final var expected = new int[]{0,1};

        assertArrayEquals(expected, TwoSum.twoSum(input, sum));
    }

    @Test
    void twoSum5() {
        final var input = new int[]{2,4,11,3};
        final var sum = 6;
        final var expected = new int[]{0,1};

        assertArrayEquals(expected, TwoSum.twoSum(input, sum));
    }
}