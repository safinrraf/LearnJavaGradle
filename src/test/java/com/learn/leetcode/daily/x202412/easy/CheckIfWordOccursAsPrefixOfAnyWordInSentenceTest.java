package com.learn.leetcode.daily.x202412.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfWordOccursAsPrefixOfAnyWordInSentenceTest {

    @Test
    void isPrefixOfWord1() {
        final String sentence = "i love eating burger";
        final String searchWord = "burg";
        final int expected = 4;
        final int result = CheckIfWordOccursAsPrefixOfAnyWordInSentence.isPrefixOfWord(sentence, searchWord);

        assertEquals(expected, result);
    }

    @Test
    void isPrefixOfWord2() {
        final String sentence = "this problem is an easy problem";
        final String searchWord = "pro";
        final int expected = 2;
        final int result = CheckIfWordOccursAsPrefixOfAnyWordInSentence.isPrefixOfWord(sentence, searchWord);

        assertEquals(expected, result);
    }

    @Test
    void isPrefixOfWord3() {
        final String sentence = "i am tired";
        final String searchWord = "you";
        final int expected = -1;
        final int result = CheckIfWordOccursAsPrefixOfAnyWordInSentence.isPrefixOfWord(sentence, searchWord);

        assertEquals(expected, result);
    }
}