package com.learn.leetcode.daily.a202501.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/?envType=daily-question&envId=2025-01-04">Task</a>
 * <br><a href="https://leetcode.com/problems/unique-length-3-palindromic-subsequences/solutions/4190834/unique-length-3-palindromic-subsequences/?envType=daily-question&envId=2025-01-04">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash Table, String, Bit Manipulation, Prefix Sum}
 * </ul>
 * <ul>Hints
 * <li> {@code What is the maximum number of length-3 palindromic strings?}
 * <li> {@code How can we keep track of the characters that appeared to the left of a given position?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 3 <= s.length <= 10^5}
 * <li> {@code s consists of only lowercase English letters.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 04.01.25 17:37
 */
public final class UniqueLength3PalindromicSubsequences {

    /**
     * Approach 2: Pre-Compute First and Last Indices
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param s
     * @return the number of <b>unique palindromes of length three</b> that are a subsequence of {@code s}.
     */
    public static int countPalindromicSubsequence(String s) {
        final int[] first = new int[26];
        final int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            final int curr = s.charAt(i) - 'a';
            if (first[curr] == - 1) {
                first[curr] = i;
            }

            last[curr] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            final Set<Character> between = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++) {
                between.add(s.charAt(j));
            }

            ans += between.size();
        }

        return ans;
    }
}
