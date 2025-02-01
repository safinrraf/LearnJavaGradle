package com.learn.leetcode.daily.w2024.q202410.medium;


/**
 * <a href="https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/?envType=daily-question&envId=2024-10-27">Task</a>
 * <br><a href="https://leetcode.com/problems/count-square-submatrices-with-all-ones/solutions/5972616/explained-step-by-step-beats-100-working-27-10-2024/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Dynamic Programming, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code Create an additive table that counts the sum of elements of sub-matrix with the superior corner at (0,0).}
 * <li> {@code Loop over all sub-squares in O(n^3) and check if the sum make the whole array to be ones, if it checks then add 1 to the answer.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= arr.length <= 300}
 * <li> {@code 1 <= arr[0].length <= 300}
 * <li> {@code 0 <= arr[i][j] <= 1}
 * </ul>
 * <br>@since 1.0.0
 * <br> 27.10.24 13:34
 */
public final class CountSquareSubmatricesWithAllOnes {

    /**
     * <p>Time complexity {@code O(N * M)}</p>
     * <p>Space complexity {@code O(N * M)}</p>
     * @param matrix matrix of ones and zeros.
     * @return how many square sub-matrices have all ones.
     */
    public static int countSquares(int[][] matrix) {
        // Create a DP table with same dimensions as matrix.
        final var dp_matrix = new int[matrix.length/*number of rows*/]
                                     [matrix[0].length/*number of columns*/];
        int result = 0;

        // Initialize first column of DP table.
        for (int i = 0; i < matrix.length; i++) {
            dp_matrix[i][0] = matrix[i][0];
            result += dp_matrix[i][0];
        }

        // Initialize first row of DP table.
        for (int j = 1; j < matrix[0].length; j++) {
            dp_matrix[0][j] = matrix[0][j];
            result += dp_matrix[0][j];
        }

        /*
         * for example
         *   {0,1,1,1}
         *   {1,1,1,1}
         *   {0,1,1,1}
         */
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1) {
                    dp_matrix[i][j] = 1 + Math.min(Math.min(dp_matrix[i][j-1], dp_matrix[i-1][j]), dp_matrix[i-1][j-1]);
                }
                result += dp_matrix[i][j];
            }
        }

        return result;
    }
}
