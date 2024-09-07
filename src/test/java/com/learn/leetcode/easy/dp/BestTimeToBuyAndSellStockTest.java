package com.learn.leetcode.easy.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

    @Test
    void maxProfit1() {
        final var input = new int[]{7, 1, 5, 3, 6, 4};
        final var result = BestTimeToBuyAndSellStock.maxProfit(input);

        assertEquals(5, result);
    }

    @Test
    void maxProfit2() {
        final var input = new int[]{7,6,4,3,1};

        assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(input));
    }
}