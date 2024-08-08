package com.learn.leetcode.easy.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStock2Test {

    @Test
    void maxProfit1() {
        final var input = new int[]{7, 1, 5, 3, 6, 4};
        final var expected = 7;

        assertEquals(expected, BestTimeToBuyAndSellStock2.maxProfit(input));
    }

    @Test
    void maxProfit2() {
        final var input = new int[]{1,2,3,4,5};
        final var expected = 4;

        assertEquals(expected, BestTimeToBuyAndSellStock2.maxProfit(input));
    }

    @Test
    void maxProfit3() {
        final var input = new int[]{7,6,4,3,1};
        final var expected = 0;

        assertEquals(expected, BestTimeToBuyAndSellStock2.maxProfit(input));
    }
}