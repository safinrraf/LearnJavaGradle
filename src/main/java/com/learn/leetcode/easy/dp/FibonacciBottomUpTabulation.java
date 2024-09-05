package com.learn.leetcode.easy.dp;

public final class FibonacciBottomUpTabulation {

    public static long fibonacciBottomUpTabulation(long n) {
        if(n == 0L || n == 1L) {
            return n;
        }

        final var dp = new long[(int) n + 1];
        dp[0] = 0L;
        dp[1] = 1L;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[(int) n];
    }

}
