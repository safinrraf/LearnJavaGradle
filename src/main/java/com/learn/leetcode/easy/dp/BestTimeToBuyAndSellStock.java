package com.learn.leetcode.easy.dp;

/**
 * <a href="https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/572/">Task</a>
 */
public final class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        var nextIndex = 0;
        var min_price = Integer.MAX_VALUE;
        var max_margin = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[++nextIndex]) {
                if(prices[i] < min_price) {
                    min_price = prices[i];
                }
                if(max_margin < (prices[nextIndex] - min_price)) {
                    max_margin = prices[nextIndex] - min_price;
                }
            }
        }
        return max_margin;
    }
}
