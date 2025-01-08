package com.learn.leetcode.daily.a202501.easy;

/**
 * <a href="https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/?envType=daily-question&envId=2025-01-08">Task</a>
 * <br><a href="https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/editorial/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, String, Trie, Rolling Hash, String Matching, Hash Function}
 * </ul>
 * <ul>Hints
 * <li> {@code Iterate through all index pairs (i, j), such that i < j, and check isPrefixAndSuffix(words[i], words[j]).}
 * <li> {@code The answer is the total number of pairs where isPrefixAndSuffix(words[i], words[j]) == true.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= words.length <= 50}
 * <li> {@code 1 <= words[i].length <= 10}
 * <li> {@code words[i] consists only of lowercase English letters.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 08.01.25 08:25
 */
public final class CountPrefixAndSuffixPairs1 {

    /**
     *
     * <p>
     * {@code Time Complexity O(N^2)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param words a 0-indexed string array words.
     * @return an integer denoting the <b>number</b> of index pairs {@code (i, j)} such that {@code i < j}, and {@code isPrefixAndSuffix(words[i], words[j])} is {@code true}.
     */
    public static int countPrefixSuffixPairs(String[] words) {
        final int N = words.length;
        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
