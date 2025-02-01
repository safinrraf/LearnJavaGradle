package com.learn.leetcode.daily.w2024.x202412.medium;

/**
 * <a href="https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/?envType=daily-question&envId=2024-12-05">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Two Pointers, String}
 * </ul>
 * <ul>Hints
 * <li> {@code After some sequence of moves, can the order of the pieces change?}
 * <li> {@code Try to match each piece in s with a piece in e.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == start.length == target.length}
 * <li> {@code 1 <= n <= 10^5}
 * <li> {@code start and target consist of the characters 'L', 'R', and '_'.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 05.12.24 11:10
 */
public final class MovePiecesToObtainString {

    /**
     * <p>You are given two strings start and target, both of length n.</p>
     *
     * @param start
     * @param target
     * @return {@code true} if it is possible to obtain the string {@code target} by moving the pieces of the string {@code start} any number of times. Otherwise, return {@code false}.
     */
    public static boolean canChange(String start, String target) {
        if (start.equals(target)) {
            return true;
        }
        int waitL = 0;
        int waitR = 0;

        for (int i = 0; i < start.length(); i++) {
            char curr = start.charAt(i);
            char goal = target.charAt(i);

            if (curr == 'R') {
                if (waitL > 0) {
                    return false;
                }
                waitR++;
            }
            if (goal == 'L') {
                if (waitR > 0) {
                    return false;
                }
                waitL++;
            }
            if (goal == 'R') {
                if (waitR == 0) {
                    return false;
                }
                waitR--;
            }
            if (curr == 'L') {
                if (waitL == 0) {
                    return false;
                }
                waitL--;
            }
        }

        return waitL == 0 && waitR == 0;
    }
}
