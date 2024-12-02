package com.learn.leetcode.daily.x202412.easy;

/**
 * <a href="https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/?envType=daily-question&envId=2024-12-02">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Two Pointers, String, String Matching}
 * </ul>
 * <ul>Hints
 * <li> {@code First extract the words of the sentence.}
 * <li> {@code Check for each word if searchWord occurs at index 0, if so return the index of this word (1-indexed)}
 * <li> {@code If searchWord doesn't exist as a prefix of any word return the default value (-1).}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= sentence.length <= 100}
 * <li> {@code 1 <= searchWord.length <= 10}
 * <li> {@code sentence consists of lowercase English letters and spaces.}
 * <li> {@code searchWord consists of lowercase English letters.}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 02.12.24 08:24
 */
public final class CheckIfWordOccursAsPrefixOfAnyWordInSentence {

    /**
     *
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(N)}
     *
     * @param sentence
     * @param searchWord
     * @return the index of the word in {@code sentence} (1-indexed) where {@code searchWord} is a prefix of this word.
     */
    public static int isPrefixOfWord(String sentence, String searchWord) {
        final var words_in_sentence = sentence.split(" ");
        int result = 1;
        for(final var word : words_in_sentence) {
            if(word.startsWith(searchWord)) {
                return result;
            }
            result++;
        }
        return -1;
    }
}
