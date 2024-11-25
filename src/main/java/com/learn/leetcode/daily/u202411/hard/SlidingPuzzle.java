package com.learn.leetcode.daily.u202411.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
public final class SlidingPuzzle {

    /**
     * {@code Time Complexity O(...)}
     * {@code Space Complexity O(...)}
     *
     * @param board an {@code 2 x 3} board
     * @return the least number of moves required so that the state of the board is solved.
     */
    public int slidingPuzzle(int[][] board) {
        // Directions for possible swaps based on '0' position
        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String target = "123450";
        Set<String> vis = new HashSet<>(); // Track visited configurations
        Queue<String> q = new LinkedList<>();
        String start = "";

        // Convert 2D board to a single string
        for (int[] row : board) {
            for (int col : row) {
                start += col;
            }
        }

        q.offer(start);
        vis.add(start);
        int step = 0;

        // Perform BFS
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String current = q.poll();

                // Check if target is reached
                if (current.equals(target)) return step;

                int zero = current.indexOf('0'); // Find position of '0'

                // Generate next moves
                for (int move : dir[zero]) {
                    StringBuilder next = new StringBuilder(current);
                    char temp = next.charAt(zero);
                    next.setCharAt(zero, next.charAt(move));
                    next.setCharAt(move, temp);

                    if (!vis.contains(next.toString())) { // Add unvisited states to the queue
                        vis.add(next.toString());
                        q.offer(next.toString());
                    }
                }
            }
            step++;
        }
        return -1; // Return -1 if target is unreachable
    }
}
