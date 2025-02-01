package com.learn.leetcode.daily.w2024.q202409;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/convert-1d-array-into-2d-array/description/?envType=daily-question&envId=2024-09-01">Task</a>
 */
public final class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        final var result = new int[m][];

        if ((m * n == original.length ? 1 : 0) == 1) {
            int i = 0;
            while (i < m) {
                result[i] = Arrays.copyOfRange(original, i * n, i * n + n);
                i++;
            }
        } else {
            return new int[0][0];
        }

        return result;
    }
}
