package com.learn.leetcode.daily.q202410.medium;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description/?envType=daily-question&envId=2024-10-21">Task</a>
 * <br><a href="https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/solutions/5944986/easy-backtracking-solution-python-java-c/?envType=daily-question&envId=2024-10-21">Explanation</a>
 * <ul>Topics
 * <li> {@code Hash Table, String, Backtracking}
 * </ul>
 * <ul>Hints
 * <li> {@code Use a set to keep track of which substrings have been used already.}
 * <li> {@code Try each possible substring at every position and backtrack if a complete split is not possible.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= s.length <= 16}
 * <li> {@code s contains only lower case English letters.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 21.10.24 20:50
 */
public final class SplitStringIntoTheMaxNumberOfUniqueSubstrings {

    /**
     * {@code Time Complexity O(2^N)}
     * {@code Space Complexity O(N)}
     * @param s input string.
     * @return Given a string {@code s}, return the maximum number of unique substrings that the given string can be split into.
     */
    public static int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }

    /**
     * This function starts at index start and explores all possible substrings starting from that position.
     * @param start
     * @param s
     * @param seen
     * @return
     */
    private static int backtrack(int start, String s, HashSet<String> seen) {
        //When start == len(s), it means we've reached the end of the string, and we can't split any further, so we return 0.
        if (start == s.length()) {
            return 0;
        }
        int maxSplits = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            final var substring = s.substring(start, end);
            if(!seen.contains(substring)) {
                seen.add(substring);
                maxSplits = Math.max(maxSplits, 1 + backtrack(end, s, seen));
                seen.remove(substring);
            }
        }
        return maxSplits;
    }
}
