package com.learn.leetcode.daily.a202501.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/count-vowel-strings-in-ranges/description/?envType=daily-question&envId=2025-01-02">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, String, Prefix Sum}
 * </ul>
 * <ul>Hints
 * <li> {@code Precompute the prefix sum of strings that start and end with vowels.}
 * <li> {@code Use unordered_set to store vowels.}
 * <li> {@code Check if the first and last characters of the string are present in the vowels set.}
 * <li> {@code Subtract prefix sum for range [l-1, r] to find the number of strings starting and ending with vowels.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= words.length <= 10^5}
 * <li> {@code 1 <= words[i].length <= 40}
 * <li> {@code words[i] consists only of lowercase English letters.}
 * <li> {@code sum(words[i].length) <= 3 * 10^5}
 * <li> {@code 1 <= queries.length <= 10^5}
 * <li> {@code 0 <= l-i <= r-i < words.length}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 02.01.25 20:04
 */
public final class CountVowelStringsInRanges {

    /**
     * my solution, almost
     * <p>Note that the vowel letters are {@code 'a'}, {@code 'e'}, {@code 'i'}, {@code 'o'}, and {@code 'u'}.</p>
     * <p>
     * {@code Time Complexity O(N + Q)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param words
     * @param queries
     * @return an array {@code ans} of size {@code queries.length}, where {@code ans[i]} is the answer to the {@code i-th} query.
     */
    public static int[] vowelStrings(String[] words, int[][] queries) {
        final int N = words.length;
        final int[] prefix_sum = new int[N];
        final int[] result = new int[queries.length];
        //hint #2
        final Set<Character> vowels = new HashSet<>(5);
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        //hint #1
        int tmp_sum = 0;
        for(int i = 0; i < N; i++) {
            if(vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                tmp_sum++;
            }
            prefix_sum[i] = tmp_sum;
        }

        //hint #4
        for(int i = 0; i < queries.length; i++) {
            int[] currentQuery = queries[i];
            result[i] =
                    prefix_sum[currentQuery[1]] -
                            (currentQuery[0] == 0 ? 0 : prefix_sum[currentQuery[0] - 1]);
        }

        return result;
    }

    public int[] vowelStrings_editoral(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u')
        );
        int[] prefixSum = new int[words.length];
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (
                    vowels.contains(currentWord.charAt(0)) &&
                            vowels.contains(currentWord.charAt(currentWord.length() - 1))
            ) {
                sum++;
            }
            prefixSum[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] currentQuery = queries[i];
            ans[i] =
                    prefixSum[currentQuery[1]] -
                            (currentQuery[0] == 0 ? 0 : prefixSum[currentQuery[0] - 1]);
        }

        return ans;
    }
}
