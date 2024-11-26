package com.learn.leetcode.daily.u202411.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/find-champion-ii/description/?envType=daily-question&envId=2024-11-26">Task</a>
 * <br><a href="https://leetcode.com/problems/find-champion-ii/solutions/6083421/video-beats-100-simple-short/">Explanation</a>
 * <ul>Topics
 * <li> {@code Graph}
 * </ul>
 * <ul>Hints
 * <li> {@code The champion(s) should have in-degree 0 in the DAG.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= n <= 100}
 * <li> {@code m == edges.length}
 * <li> {@code 0 <= m <= n * (n - 1) / 2}
 * <li> {@code edges[i].length == 2}
 * <li> {@code 0 <= edge[i][j] <= n - 1}
 * <li> {@code edges[i][0] != edges[i][1]}
 * <li> {@code The input is generated such that if team a is stronger than team b, team b is not stronger than team a.}
 * <li> {@code The input is generated such that if team a is stronger than team b and team b is stronger than team c, then team a is stronger than team c.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 26.11.24 08:20
 */
public final class FindChampion2 {

    /**
     *
     * @param n
     * @param edges
     * @return the team that will be the champion of the tournament if there is a unique champion, otherwise, return {@code -1}.
     */
    public static int findChampion(int n, int[][] edges) {
        boolean[] isUndefeated = new boolean[n];
        Arrays.fill(isUndefeated, true);

        for (int[] edge : edges) {
            int winner = edge[0];
            int loser = edge[1];
            isUndefeated[loser] = false;
        }

        int champion = -1;
        int championCount = 0;

        for (int team = 0; team < n; team++) {
            if (isUndefeated[team]) {
                champion = team;
                championCount++;
            }
        }

        return championCount == 1 ? champion : -1;
    }
}
