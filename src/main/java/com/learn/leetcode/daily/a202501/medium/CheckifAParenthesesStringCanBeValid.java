package com.learn.leetcode.daily.a202501.medium;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/?envType=daily-question&envId=2025-01-12">Task</a>
 * <br><a href="https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/editorial/?envType=daily-question&envId=2025-01-12">Explanation</a>
 * <ul>Topics
 * <li> {@code String, Stack, Greedy}
 * </ul>
 * <ul>Hints
 * <li> {@code Can an odd length string ever be valid?}
 * <li> {@code From left to right, if a locked ')' is encountered, it must be balanced with either a locked '(' or an unlocked index on its left. If neither exist, what conclusion can be drawn? If both exist, which one is more preferable to use?}
 * <li> {@code After the above, we may have locked indices of '(' and additional unlocked indices. How can you balance out the locked '(' now? What if you cannot balance any locked '('?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == s.length == locked.length}
 * <li> {@code 1 <= n <= 10^5}
 * <li> {@code s[i] is either '(' or ')'.}
 * <li> {@code locked[i] is either '0' or '1'.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 12.01.25 18:17
 */
public final class CheckifAParenthesesStringCanBeValid {

    /**
     * Approach 1: Stack
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param s
     * @param locked
     * @return {@code true} if you can make {@code s} a valid parentheses string. Otherwise, return {@code false}.
     */
    public static boolean canBeValid(String s, String locked) {
        final int length = s.length();

        // If length of string is odd, return false.
        if (length % 2 == 1) {
            return false;
        }

        final Stack<Integer> openBrackets = new Stack<>();
        final Stack<Integer> unlocked = new Stack<>();

        // Iterate through the string to handle '(' and ')'
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }

        // Match remaining open brackets with unlocked characters
        while (
                !openBrackets.empty() &&
                        !unlocked.empty() &&
                        openBrackets.peek() < unlocked.peek()
        ) {
            openBrackets.pop();
            unlocked.pop();
        }

        return openBrackets.empty();
    }
}
