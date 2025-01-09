package com.learn.leetcode.daily.a202501.easy;

/**
 * <a href="https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, String, String Matching}
 * </ul>
 * <ul>Hints
 * <li> {@code Go through each word in words and increment the answer if pref is a prefix of the word.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= words.length <= 100}
 * <li> {@code 1 <= words[i].length, pref.length <= 100}
 * <li> {@code words[i] and pref consist of lowercase English letters.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 09.01.25 08:14
 */
public final class CountingWordsWithGivenPrefix {

    /**
     *
     * <p>
     * {@code Time Complexity O(N * M), where M is a length of a word}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param words an array of strings.
     * @param pref a searched prefix.
     * @return the number of strings in {@code words} that contain {@code pref} as a <b>prefix</b>.
     */
    public static int prefixCount(String[] words, String pref) {
        int answer = 0;

        for(final var word : words) {
            if(word.startsWith(pref)) {
                answer++;
            }
        }

        return answer;
    }
}
