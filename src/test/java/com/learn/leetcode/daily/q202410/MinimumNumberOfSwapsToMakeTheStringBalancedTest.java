package com.learn.leetcode.daily.q202410;

import com.learn.leetcode.daily.q202410.medium.MinimumNumberOfSwapsToMakeTheStringBalanced;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfSwapsToMakeTheStringBalancedTest {

    @Test
    void minSwaps1() {
        final var input = "][][";
        final var expected = 1;
        final var result = MinimumNumberOfSwapsToMakeTheStringBalanced.minSwaps(input);

        assertEquals(expected, result);
    }

    @Test
    void minSwaps2() {
        final var input = "]]][[[";
        final var expected = 2;
        final var result = MinimumNumberOfSwapsToMakeTheStringBalanced.minSwaps(input);

        assertEquals(expected, result);
    }

    @Test
    void minSwaps3() {
        final var input = "[]";
        final var expected = 0;
        final var result = MinimumNumberOfSwapsToMakeTheStringBalanced.minSwaps(input);

        assertEquals(expected, result);
    }

    @Test
    void minSwaps4() {
        final var input = "[[][]]";
        final var expected = 0;
        final var result = MinimumNumberOfSwapsToMakeTheStringBalanced.minSwaps(input);

        assertEquals(expected, result);
    }
}