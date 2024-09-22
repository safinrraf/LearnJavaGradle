package com.learn.leetcode.daily.q202409;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/?envType=daily-question&envId=2024-09-22">Task</a>
 * <br><a href="https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/solutions/5818614/beats-100-easy-solution/?envType=daily-question&envId=2024-09-22">Explanation</a>
 */
public final class KthSmallestInLexicographicalOrder {
    private static int getReqNum(long a, long b, long n) {
        int gap = 0;
        while (a <= n) {
            gap += Math.min(n + 1, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }

    public static int findKthNumber(int n, int k) {
        long num = 1;
        for (int i = 1; i < k;) {
            int req = getReqNum(num, num + 1, n);
            if (i + req <= k) {
                i += req;
                num++;
            } else {
                i++;
                num *= 10;
            }
        }
        return (int) num;
    }
}
