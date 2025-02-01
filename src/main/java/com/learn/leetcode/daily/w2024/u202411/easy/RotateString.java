package com.learn.leetcode.daily.w2024.u202411.easy;

/**
 * <a href="https://leetcode.com/problems/rotate-string/description/?envType=daily-question&envId=2024-11-03">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code String, String Matching}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length, goal.length <= 100}
 * <li> {@code s and goal consist of lowercase English letters.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 03.11.24 14:34
 */
public final class RotateString {

    /**
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(N)}
     * @param s
     * @param goal
     * @return {@code true} if and only if {@code s} can become {@code goal} after some number of shifts on {@code s}.
     */
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        return (s + s).contains(goal);
    }
}
