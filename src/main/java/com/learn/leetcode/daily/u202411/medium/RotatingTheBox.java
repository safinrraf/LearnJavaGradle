package com.learn.leetcode.daily.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/rotating-the-box/description/?envType=daily-question&envId=2024-11-23">Task</a>
 * <br><a href="https://leetcode.com/problems/rotating-the-box/solutions/6073408/easy-video-solution-and-explanation-with-short-implementation-simulation-c/?envType=daily-question&envId=2024-11-23">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Two Pointers, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code Rotate the box using the relation rotatedBox[i][j] = box[m - 1 - j][i].}
 * <li> {@code Start iterating from the bottom of the box and for each empty cell check if there is any stone above it with no obstacles between them.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == box.length}
 * <li> {@code n == box[i].length}
 * <li> {@code 1 <= m, n <= 500}
 * <li> {@code box[i][j] is either '#', '*', or '.'.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 23.11.24 20:55
 */
public final class RotatingTheBox {

    /**
     * 00, 01, 02
     *
     * 00
     * 10
     * 20
     *
     * @param box an {@code m x n} matrix of characters box representing a side-view of a box.
     * @return an {@code n x m} matrix representing the box after the rotation described above.
     */
    public static char[][] rotateTheBoxMineAndAlmost(char[][] box) {
        final char[][] rotatedBox = new char[box[0].length][box.length];
        int rows = box.length;
        int cols = box[0].length;

        //rotating the box
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                rotatedBox[j][rows - 1 - i] = box[i][j];
            }
        }

        rows = rotatedBox.length;
        cols = rotatedBox[0].length;
        //falling the # (stones)
        for(int j = 0; j < cols; j++) {
            for(int i = rows - 1; i > 0; i--) {
                final var upper_cell = rotatedBox[i - 1][j];
                final var current_cell = rotatedBox[i][j];

                if(upper_cell == '#' && current_cell == '.') {
                    var stop_index = i;
                    while(stop_index < rows  || rotatedBox[stop_index][j] != '#' || rotatedBox[stop_index][j] != '*') {
                        stop_index++;
                    }

                    rotatedBox[i - 1][j] = '.';
                    rotatedBox[stop_index][j] = '#';
                }
            }
        }

        return rotatedBox;
    }

    public static void printBox(char[][] box) {
        for (char[] row : box) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    /**
     * {@code Time Complexity O(M * N)}
     * {@code Space Complexity O(1)}
     *
     * @param box
     * @return
     */
    public static char[][] rotateTheBox(char[][] box) {
        int n = box.length, m = box[0].length;

        // Apply gravity
        for (int i = 0; i < n; i++) {
            int empty = m - 1; // Rightmost empty cell
            for (int j = m - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    empty = j - 1; // Reset empty pointer after obstacle
                } else if (box[i][j] == '#') {
                    char temp = box[i][j];
                    box[i][j] = '.';
                    box[i][empty] = temp;
                    empty--;
                }
            }
        }

        // Rotate the box 90 degrees clockwise
        char[][] rotated = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = box[i][j];
            }
        }

        return rotated;
    }

    public static char[][] rotateTheBoxSuperFast(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] res = new char[n][m];
        for (int i = 0; i < m; ++i)
            for (int j = n - 1, k = n - 1; j >= 0; --j) {
                res[j][m - i - 1] = '.';
                if (box[i][j] != '.') {
                    k = box[i][j] == '*' ? j : k;
                    res[k--][m - i - 1] = box[i][j];
                }
            }
        return res;
    }
}
