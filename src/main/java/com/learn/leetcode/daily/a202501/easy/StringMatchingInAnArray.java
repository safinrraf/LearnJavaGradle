package com.learn.leetcode.daily.a202501.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/string-matching-in-an-array/description/?envType=daily-question&envId=2025-01-07">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, String, String Matching}
 * </ul>
 * <ul>Hints
 * <li> {@code Bruteforce to find if one string is substring of another or use KMP algorithm.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= words.length <= 100}
 * <li> {@code 1 <= words[i].length <= 30}
 * <li> {@code words[i] contains only lowercase English letters.}
 * <li> {@code All the strings of words are unique.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 07.01.25 08:19
 */
public final class StringMatchingInAnArray {

    /**
     *
     * <p>
     * {@code Time Complexity O(N^2 * M)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param words  an array of string (see constraints).
     * @return all strings in {@code words} that is a <b>substring</b> of another word. You can return the answer in any order.
     */
    public static List<String> stringMatching(String[] words) {
        final int N = words.length;
        final List<String> answer = new ArrayList<>(N);

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && words[j].contains(words[i])) {
                    answer.add(words[i]);
                    break;
                }
            }
        }

        return answer;
    }
}
