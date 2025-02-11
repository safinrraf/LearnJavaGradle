package com.learn.leetcode.daily.b202502.medium;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/?envType=daily-question&envId=2025-02-11">Task</a>
 * <br><a href="https://leetcode.com/problems/remove-all-occurrences-of-a-substring/editorial/?envType=daily-question&envId=2025-02-11">Explanation</a>
 * <ul>Topics
 * <li> {@code String, Stack, Simulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Note that a new occurrence of pattern can appear if you remove an old one, For example, s = "ababcc" and pattern = "abc".}
 * <li> {@code You can maintain a stack of characters and if the last character of the pattern size in the stack match the pattern remove them}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length <= 1000}
 * <li> {@code 1 <= part.length <= 1000}
 * <li> {@code s and part consists of lowercase English letters.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 11.02.25 10:43
 */
public final class RemoveAllOccurrencesOfSubstring {

    /**
     * Approach 2: Stack
     * <p>
     * {@code Time Complexity O(n * m)}<br>
     * {@code Space Complexity O(n + m)}
     * </p>
     * @param s
     * @param part
     * @return {@code s} after removing all occurrences of {@code part}.
     */
    public static String removeOccurrences(String s, String part) {
        Stack<Character> stk = new Stack<>();
        int strLength = s.length();
        int partLength = part.length();

        // Iterate through each character in the string
        for (int index = 0; index < strLength; index++) {
            // Push current character to stack
            stk.push(s.charAt(index));

            // If stack size is greater than or equal to the part length, check for match
            if (stk.size() >= partLength && checkMatch(stk, part, partLength)) {
                // Pop the characters matching 'part' from the stack
                for (int j = 0; j < partLength; j++) {
                    stk.pop();
                }
            }
        }

        // Convert stack to string with correct order
        StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        result.reverse();

        return result.toString();
    }

    // Helper function to check if the top of the stack matches the 'part'
    private static boolean checkMatch(
            Stack<Character> stk,
            String part,
            int partLength
    ) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stk); // Copy the stack to avoid modifying the original

        // Iterate through part from right to left
        for (int partIndex = partLength - 1; partIndex >= 0; partIndex--) {
            // If current stack top doesn't match expected character
            if (temp.isEmpty() || temp.peek() != part.charAt(partIndex)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}
