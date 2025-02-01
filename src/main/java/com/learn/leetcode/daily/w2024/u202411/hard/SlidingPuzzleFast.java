package com.learn.leetcode.daily.w2024.u202411.hard;


/**
 * <a href="https://leetcode.com/problems/sliding-puzzle/description/?envType=daily-question&envId=2024-11-25">Task</a>
 * <br><a href="https://theory.stanford.edu/~amitp/GameProgramming/Heuristics.html">Explanation</a>
 * <br><a href="https://leetcode.com/problems/sliding-puzzle/solutions/6080641/simple-bfs-solution-beats-100-breadth-first-search-c-java-python-javascript/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Breadth-First Search, Matrix}
 * </ul>
 * <ul>Hints
 * <li> {@code Perform a breadth-first-search, where the nodes are the puzzle boards and edges are if two puzzle boards can be transformed into one another with one move.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code board.length == 2}
 * <li> {@code board[i].length == 3}
 * <li> {@code 0 <= board[i][j] <= 5}
 * <li> {@code Each value board[i][j] is unique.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 25.11.24 08:22
 */
public final class SlidingPuzzleFast {
    int min = Integer.MAX_VALUE;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int slidingPuzzle(int[][] board) {
        int[] zero = {-1, -1};
        outer:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zero = new int[]{i, j};
                    break outer;
                }
            }
        }
        helper_backtrack(board, 0, new int[]{-1, -1}, zero);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public void helper_backtrack(int[][] board, int moves, int[] last, int[] curr) {
        if (moves >= 20) return;
        if (helper_isDone(board)) {
            min = Math.min(min, moves);
            return;
        }
        for (int[] dir : dirs) {
            int i = curr[0] + dir[0];
            int j = curr[1] + dir[1];
            if (i < 0 || i >= 2 || j < 0 || j >= 3 || (last[0] == i && last[1] == j)) continue;
            int[] newMove = {i, j};
            helper_flip(board, curr, newMove);
            helper_backtrack(board, moves + 1, curr, newMove);
            helper_flip(board, curr, newMove);
        }
    }
    public void helper_flip(int[][] board, int[] f, int[] s) {
        int temp = board[f[0]][f[1]];
        board[f[0]][f[1]] = board[s[0]][s[1]];
        board[s[0]][s[1]] = temp;
    }
    public boolean helper_isDone(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 2) return true;
                if (board[i][j] != 3 * i + j + 1) return false;
            }
        }
        return true;
    }
}
