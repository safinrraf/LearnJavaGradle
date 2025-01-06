package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/?envType=daily-question&envId=2025-01-06">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/solutions/6210124/minimum-number-of-operations-to-move-all-balls-to-each-box/?envType=daily-question&envId=2025-01-06">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, String, Prefix Sum}
 * </ul>
 * <ul>Hints
 * <li> {@code If you want to move a ball from box i to box j, you'll need abs(i-j) moves.}
 * <li> {@code To move all balls to some box, you can move them one by one.}
 * <li> {@code For each box i, iterate on each ball in a box j, and add abs(i-j) to answers[i].}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == boxes.length}
 * <li> {@code 1 <= n <= 2000}
 * <li> {@code boxes[i] is either '0' or '1'.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 06.01.25 18:57
 */
public final class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    /**
     * Approach 2: Sum of Left and Right Moves.
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param boxes
     * @return an array {@code answer} of size {@code n}, where {@code answer[i]} is the <b>minimum number</b> of operations needed to move all the balls to the {@code i-th} box.
     */
    public static int[] minOperations(String boxes) {
        final int N = boxes.length();
        final int[] answer = new int[N];

        int ballsToLeft = 0, movesToLeft = 0;
        int ballsToRight = 0, movesToRight = 0;

        // Single pass: calculate moves from both left and right
        for (int i = 0; i < N; i++) {
            // Left pass
            answer[i] += movesToLeft;
            ballsToLeft += boxes.charAt(i) == '1' ? 1 : 0;
            movesToLeft += ballsToLeft;

            // Right pass
            final int j = N - 1 - i;
            answer[j] += movesToRight;
            ballsToRight += boxes.charAt(j) == '1' ? 1 : 0;
            movesToRight += ballsToRight;
        }

        return answer;
    }
}
