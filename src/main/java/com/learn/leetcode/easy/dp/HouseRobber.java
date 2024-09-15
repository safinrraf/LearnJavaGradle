package com.learn.leetcode.easy.dp;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/">Task</a>
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.">Explanation</a>
 */
public final class HouseRobber {
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
