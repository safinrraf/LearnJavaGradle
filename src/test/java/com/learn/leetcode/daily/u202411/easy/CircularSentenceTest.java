package com.learn.leetcode.daily.u202411.easy;

import com.learn.leetcode.daily.w2024.u202411.easy.CircularSentence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularSentenceTest {

    @Test
    void isCircularSentence1() {
        var sentence = "leetcode exercises sound delightful";

        assertTrue(CircularSentence.isCircularSentence(sentence));
    }

    @Test
    void isCircularSentence2() {
        var sentence = "eetcode";

        assertTrue(CircularSentence.isCircularSentence(sentence));
    }

    @Test
    void isCircularSentence3() {
        var sentence = "Leetcode is cool";

        assertFalse(CircularSentence.isCircularSentence(sentence));
    }

    @Test
    void isCircularSentence4() {
        var sentence = "Leetcode is cool";

        assertFalse(CircularSentence.isCircularSentence(sentence));
    }

    @Test
    void isCircularSentence5() {
        var sentence = "happy Leetcode";

        assertFalse(CircularSentence.isCircularSentence(sentence));
    }

    @Test
    void isCircularSentence6() {
        var sentence = "Leetcode";

        assertFalse(CircularSentence.isCircularSentence(sentence));
    }

    @Test
    void isCircularSentence7() {
        var sentence = "I like Leetcode";

        assertFalse(CircularSentence.isCircularSentence(sentence));
    }

    @Test
    void isCircularSentence8() {
        var sentence = "ab a";

        assertFalse(CircularSentence.isCircularSentence(sentence));
    }
}