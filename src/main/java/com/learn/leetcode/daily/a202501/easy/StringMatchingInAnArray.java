package com.learn.leetcode.daily.a202501.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/string-matching-in-an-array/description/?envType=daily-question&envId=2025-01-07">Task</a>
 * <br><a href="https://leetcode.com/problems/string-matching-in-an-array/solutions/6236300/string-matching-in-an-array/">Explanation</a>
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

    /**
     * Approach 2: KMP Algorithm.
     * <p>
     * {@code Time Complexity O(N^2 * M)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param words  an array of string (see constraints).
     * @return all strings in {@code words} that is a <b>substring</b> of another word. You can return the answer in any order.
     */
    public static List<String> stringMatching_KMP(String[] words) {
        List<String> matchingWords = new ArrayList<>();

        // Iterate through each word in the input array.
        for (
                int currentWordIndex = 0;
                currentWordIndex < words.length;
                currentWordIndex++
        ) {
            int[] lps = computeLPSArray(words[currentWordIndex]);
            // Compare the current word with all other words.
            for (
                    int otherWordIndex = 0;
                    otherWordIndex < words.length;
                    otherWordIndex++
            ) {
                if (currentWordIndex == otherWordIndex) continue; // Skip comparing the word with itself.

                // Check if the current word is a substring of another word.
                if (
                        isSubstringOf(
                                words[currentWordIndex],
                                words[otherWordIndex],
                                lps
                        )
                ) {
                    matchingWords.add(words[currentWordIndex]); // Add it to the result list if true.
                    break; // No need to check further for this word.
                }
            }
        }

        return matchingWords;
    }

    // Function to compute the LPS (Longest Prefix Suffix) array for the substring 'sub'.
    private static int[] computeLPSArray(String sub) {
        int[] lps = new int[sub.length()];
        int currentIndex = 1;
        int len = 0;

        while (currentIndex < sub.length()) {
            if (sub.charAt(currentIndex) == sub.charAt(len)) {
                len++;
                lps[currentIndex] = len;
                currentIndex++;
            } else {
                if (len > 0) {
                    len = lps[len - 1]; // Backtrack using LPS array to find a shorter match.
                } else {
                    currentIndex++;
                }
            }
        }
        return lps;
    }

    // Function to check if 'sub' is a substring of 'main' using the KMP algorithm.
    private static boolean isSubstringOf(String sub, String main, int[] lps) {
        int mainIndex = 0;
        int subIndex = 0;

        while (mainIndex < main.length()) {
            if (main.charAt(mainIndex) == sub.charAt(subIndex)) {
                mainIndex++;
                subIndex++;
                if (subIndex == sub.length()) return true; // Found a match.
            } else {
                if (subIndex > 0) {
                    subIndex = lps[subIndex - 1]; // Use the LPS to skip unnecessary comparisons.
                } else {
                    mainIndex++;
                }
            }
        }
        return false; // No match found.
    }
}
