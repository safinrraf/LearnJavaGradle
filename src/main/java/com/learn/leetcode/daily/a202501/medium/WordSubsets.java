package com.learn.leetcode.daily.a202501.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/word-subsets/description/?envType=daily-question&envId=2025-01-10">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, String}
 * </ul>
 * <ul>Hints
 * <li> {@code ...} 
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= words1.length, words2.length <= 10^4}
 * <li> {@code 1 <= words1[i].length, words2[i].length <= 10}
 * <li> {@code words1[i] and words2[i] consist only of lowercase English letters.}
 * <li> {@code All the strings of words1 are unique.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 10.01.25 08:22
 */

public final class WordSubsets {

    /**
     *
     * <p>
     * {@code Time Complexity O(Words1 + Words2)}<br>
     * {@code Space Complexity O(Words1.length + Words2.length)}
     * </p>
     * @param words1 an array of strings.
     * @param words2 an array of strings.
     * @return an array of all the <b>universal</b> strings in {@code words1}. You may return the answer in any order.
     */
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bmax = count("");
        for (final String b: words2) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        final List<String> ans = new ArrayList();
        search: for (final String a: words1) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    continue search;
            ans.add(a);
        }

        return ans;
    }

    public static int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}
