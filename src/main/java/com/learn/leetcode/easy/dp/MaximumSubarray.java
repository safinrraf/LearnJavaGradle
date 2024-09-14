package com.learn.leetcode.easy.dp;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/566/">Task</a>
 * <a href="https://en.wikipedia.org/wiki/Maximum_subarray_problem">Wiki</a>
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/566/discuss/1595195/C++Python-7-Simple-Solutions-w-Explanation-or-Brute-Force-+-DP-+-Kadane-+-Divide-and-Conquer">Explanation</a>
 */
public final class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int curMax = 0, maxTillNow = Integer.MIN_VALUE;
        for(var c : nums) {
            curMax = Math.max(c, curMax + c);
            maxTillNow = Math.max(maxTillNow, curMax);
        }
        return maxTillNow;
    }
}
