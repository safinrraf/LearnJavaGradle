package com.learn.leetcode.daily.q202410;

import com.learn.leetcode.daily.w2024.q202410.medium.SentenceSimilarity3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentenceSimilarity3Test {

    @Test
    void areSentencesSimilar1() {
        final var sentence1 = "Hello Jane";
        final var sentence2 = "Hello my name is Jane";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertTrue(result);
    }

    @Test
    void areSentencesSimilar2() {
        final var sentence1 = "Frog cool";
        final var sentence2 = "Frogs are cool";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertFalse(result);
    }

    @Test
    void areSentencesSimilar3() {
        final var sentence1 = "My name is Haley";
        final var sentence2 = "My Haley";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertTrue(result);
    }

    @Test
    void areSentencesSimilar4() {
        final var sentence1 = "of";
        final var sentence2 = "A lot of words";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertFalse(result);
    }

    @Test
    void areSentencesSimilar5() {
        final var sentence1 = "Eating right now";
        final var sentence2 = "Eating";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertTrue(result);
    }

    @Test
    void areSentencesSimilar6() {
        final var sentence1 = "eTUny i b R UFKQJ EZx JBJ Q xXz";
        final var sentence2 = "eTUny i R EZx JBJ xXz";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertFalse(result);
    }

    @Test
    void areSentencesSimilar7() {
        final var sentence1 = "Ogn WtWj HneS";
        final var sentence2 = "Ogn WtWj HneS";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertTrue(result);
    }

    @Test
    void areSentencesSimilar8() {
        final var sentence1 = "a";
        final var sentence2 = "a aa a";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertTrue(result);
    }

    @Test
    void areSentencesSimilar9() {
        final var sentence1 = "A";
        final var sentence2 = "a A b A";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertTrue(result);
    }

    @Test
    void areSentencesSimilar10() {
        final var sentence1 = "aa aa";
        final var sentence2 = "aa aa A";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertTrue(result);
    }

    @Test
    void areSentencesSimilar11() {
        final var sentence1 = "A A AAa";
        final var sentence2 = "A AAa";
        final var result = SentenceSimilarity3.areSentencesSimilar(sentence1, sentence2);

        assertTrue(result);
    }
}