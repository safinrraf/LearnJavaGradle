package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.CountTheNumberOfFairPairs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CountTheNumberOfFairPairsTest {

    @Test
    void countFairPairs1() {
        final int[] nums = {0,1,7,4,4,5};
        final var lower = 3;
        final var upper = 6;
        final var expected = 6L;
        final var result = CountTheNumberOfFairPairs.countFairPairs(nums, lower, upper);

        assertEquals(expected, result);
    }

    @Test
    void countFairPairs2() {
        final int[] nums = {1,7,9,2,5};
        final var lower = 11;
        final var upper = 11;
        final var expected = 1L;
        final var result = CountTheNumberOfFairPairs.countFairPairs(nums, lower, upper);

        assertEquals(expected, result);
    }
}