package com.learn.leetcode.easy.dp;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/569/">Task</a>
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/569/discuss/3708750/4-Method's-oror-Beat's-100-oror-C++-oror-JAVA-oror-PYTHON-oror-Beginner-Friendly">Explanation</a>
 */
public final class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
