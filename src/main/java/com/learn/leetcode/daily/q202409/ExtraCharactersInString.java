package com.learn.leetcode.daily.q202409;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/extra-characters-in-a-string/description/?envType=daily-question&envId=2024-09-23">Task</a>
 * <br><a href="https://leetcode.com/problems/extra-characters-in-a-string/solutions/5822172/efficient-easy-to-understand-beginner-friendly-dp/?envType=daily-question&envId=2024-09-23">Explanation</a>
 */
public final class ExtraCharactersInString {
    public static int minExtraChar(String s, String[] dictionary) {
        // Convert the dictionary list into a set for O(1) lookup time
        final Set<String> wordSet = new HashSet<>(List.of(dictionary));
        final int n = s.length();

        // dp[i] will store the minimum extra characters in the substring s[i:]
        final int[] dp = new int[n + 1];

        // Fill dp array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // By default, we assume the current character is extra
            dp[i] = dp[i + 1] + 1;

            // Try to match any word from dictionary starting at index i
            for (int length = 1; length <= n - i; length++) {
                if (wordSet.contains(s.substring(i, i + length))) {
                    dp[i] = Math.min(dp[i], dp[i + length]);
                }
            }
        }

        // The answer is the number of extra characters in the entire string
        return dp[0];
    }
}
