package com.learn.leetcode.easy.arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/">Task</a>
 */
public final class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        var nextIndex = 0;
        var profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[++nextIndex]) {
                profit += prices[nextIndex] - prices[i];
            }
        }
        return profit;
    }
}
