package com.learn.leetcode.daily.w2024.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/maximum-matrix-sum/description/?envType=daily-question&envId=2024-11-24">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Greedy, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code Try to use the operation so that each row has only one negative number.}
 * <li> {@code If you have only one negative element you cannot convert it to positive.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == matrix.length == matrix[i].length}
 * <li> {@code 2 <= n <= 250}
 * <li> {@code -10^5 <= matrix[i][j] <= 10^5}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 24.11.24 15:41
 */
public final class MaximumMatrixSum {

    /**
     * <p>
     * Your goal is to maximize the summation of the matrix's elements.<br>
     * You are given an n x n integer matrix. You can do the following operation any number of times:<br>
     * <li> Choose any two adjacent elements of {@code matrix} and multiply each of them by {@code -1}.<br>
     * Two elements are considered adjacent if and only if they share a border.
     * </p>
     * {@code Time Complexity O(N * M)}
     * {@code Space Complexity O(1)}
     *
     * @param matrix an {@code n x n} integer {@code matrix}.
     * @return the maximum sum of the matrix's elements using the operation mentioned above.
     */
    public static long maxMatrixSum(int[][] matrix) {
        final int cols = matrix[0].length;
        long result = 0L;
        int negative_count = 0;
        int the_smallest_item = Integer.MAX_VALUE;

        for (final int[] ints : matrix) {
            for (int j = 0; j < cols; j++) {
                if (ints[j] < 0) {
                    negative_count++;
                }
                final var item = Math.abs(ints[j]);
                result += item;
                the_smallest_item = Math.min(the_smallest_item, item);
            }
        }

        if ((negative_count & 1L) != 0) {
            //is odd
            result -= (2L * the_smallest_item);
        }

        return result;
    }
}
