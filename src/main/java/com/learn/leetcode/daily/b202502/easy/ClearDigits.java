package com.learn.leetcode.daily.b202502.easy;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/clear-digits/description/?envType=daily-question&envId=2025-02-10">Task</a>
 * <br><a href="https://leetcode.com/problems/clear-digits/editorial/">Explanation</a>
 * <ul>Topics
 * <li> {@code String, Stack, Simulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Process string s from left to right, if s[i] is a digit, mark the nearest unmarked non-digit index to its left.}
 * <li> {@code Delete all digits and all marked characters.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length <= 100}
 * <li> {@code s consists only of lowercase English letters and digits.}
 * <li> {@code The input is generated such that it is possible to delete all digits.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 10.02.25 09:53
 */
public final class ClearDigits {

    /**
     *  - Delete the first digit and the closest non-digit character to its left.
     *  My solution
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param s
     * @return the resulting string after removing all digits.
     */
    public static String clearDigits(String s) {
        final int N = s.length();
        final Stack<Character> stack = new Stack<>();
        int current_index = 0;
        //iterate over the string's characters.
        while (current_index < N) {
            while (!stack.isEmpty()
                    && current_index < N
                    && s.charAt(current_index) >= '0' && s.charAt(current_index) <= '9') {
                //while we see digits, then pop the characters from the stack.
                stack.pop();
                current_index++;
            }
            // Add current index to stack only if it is a character.
            if (current_index < N
                    && s.charAt(current_index) >= 'a'
                    && s.charAt(current_index) <= 'z') {
                stack.add(s.charAt(current_index));
            }
            current_index++;
        }
        // and re-build the "cleared" string.
        final StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }

    /**
     *  Approach 2: Stack-Like
     *  - Delete the first digit and the closest non-digit character to its left.
     *  Editorial
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param s
     * @return the resulting string after removing all digits.
     */
    public static String clearDigits_Editorial(String s) {
        StringBuilder answer = new StringBuilder();

        // Iterate over each character in the input string
        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            // If the current character is a digit
            if (
                    Character.isDigit(s.charAt(charIndex)) && answer.length() != 0
            ) {
                // If the answer string is not empty, remove the last character
                answer.setLength(answer.length() - 1);
            } else {
                // If the character is not a digit, add it to the answer
                answer.append(s.charAt(charIndex));
            }
        }

        return answer.toString();
    }
}
