package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/minimum-length-of-string-after-operations/description/?envType=daily-question&envId=2025-01-13">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-length-of-string-after-operations/editorial/">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash Table, String, Counting}
 * </ul>
 * <ul>Hints
 * <li> {@code Only the frequency of each character matters in finding the final answer.}
 * <li> {@code If a character occurs less than 3 times, we cannot perform any process with it.}
 * <li> {@code Suppose there is a character that occurs at least 3 times in the string, we can repeatedly delete two of these characters until there are at most 2 occurrences left of it.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length <= 2 * 10^5}
 * <li> {@code s consists only of lowercase English letters.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 13.01.25 08:05
 */
public final class MinimumLengthOfStringAfterOperations {

    /**
     * Approach 2: Using Frequency Array
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param s input string.
     * @return the <b>minimum</b> length of the final string {@code s} that you can achieve.
     */
    public static int minimumLength(String s) {
        // Initialize frequency array and oddCount
        final int[] freq = new int[26];

        // Increment the value of the index corresponding to the current character
        for (char chr : s.toCharArray()) {
            freq[chr - 'a']++;
        }

        // Calculate the number of characters to delete
        int deleteCount = 0;
        for (final int frequency : freq) {
            if(frequency == 0) {
                continue;
            }
            if (frequency % 2 == 1) {
                // If frequency is odd, delete all except one
                deleteCount += frequency - 1;
            } else {
                // If frequency is even, delete all except two
                deleteCount += frequency - 2;
            }
        }

        // Return the minimum length after deletions
        return s.length() - deleteCount;
    }
}
