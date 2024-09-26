package com.learn.leetcode.daily.q202409;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences/description/?envType=daily-question&envId=2024-09-17">Task</a>
 */
public final class UncommonWordsFromTwoSentences {

    public static String[] uncommonFromSentences(String s1, String s2) {
        final var tmpStrArr = (s1 + " " + s2).split(" ");

        // Create a HashMap to count the occurrences of each string
        final Map<String, Integer> countMap = new HashMap<>();
        for (final var word : tmpStrArr) {
            countMap.merge(word, 1, Integer::sum);
        }

        // Filter out the strings that appear more than once
        final var result = Arrays.stream(tmpStrArr)
                .filter(word -> countMap.get(word) == 1)
                .toList();

        return result.toArray(new String[0]);
    }
}
