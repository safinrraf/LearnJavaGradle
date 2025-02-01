package com.learn.leetcode.daily.q202409;

import com.learn.leetcode.daily.w2024.q202409.UncommonWordsFromTwoSentences;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UncommonWordsFromTwoSentencesTest {

    @Test
    void uncommonFromSentences1() {
        final var input1 = "this apple is sweet";
        final var input2 = "this apple is sour";
        final var expected = new String[]{"sweet", "sour"};
        final var result = UncommonWordsFromTwoSentences.uncommonFromSentences(input1, input2);

        assertArrayEquals(expected, result);
    }

    @Test
    void uncommonFromSentences2() {
        final var input1 = "apple apple";
        final var input2 = "banana";
        final var expected = new String[]{"banana"};
        final var result = UncommonWordsFromTwoSentences.uncommonFromSentences(input1, input2);

        assertArrayEquals(expected, result);
    }
}