package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class WordSubsetsTest {

    @Test
    void wordSubsets1() {
        final String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        final String[] words2 = {"e","o"};
        final List<String> expected = List.of("facebook","google","leetcode");
        final List<String> answer = WordSubsets.wordSubsets(words1, words2);

        assertEquals(expected, answer);
    }

    @Test
    void wordSubsets2() {
        final String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        final String[] words2 = {"l","e"};
        final List<String> expected = List.of("apple","google","leetcode");
        final List<String> answer = WordSubsets.wordSubsets(words1, words2);

        assertEquals(expected, answer);
    }
}