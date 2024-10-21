package com.learn.leetcode.daily.q202410;

import com.learn.leetcode.daily.q202410.medium.PermutationInString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    @Test
    void checkInclusion1() {
        final var s1 = "ab";
        final var s2 = "eidbaooo";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertTrue(result);
    }

    @Test
    void checkInclusion2() {
        final var s1 = "ab";
        final var s2 = "eidboaoo";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertFalse(result);
    }

    @Test
    void checkInclusion3() {
        final var s1 = "a";
        final var s2 = "a";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertTrue(result);
    }

    @Test
    void checkInclusion4() {
        final var s1 = "a";
        final var s2 = "f";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertFalse(result);
    }

    @Test
    void checkInclusion5() {
        final var s1 = "abc";
        final var s2 = "cab";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertTrue(result);
    }

    @Test
    void checkInclusion6() {
        final var s1 = "abc";
        final var s2 = "cabdfghjk";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertTrue(result);
    }

    @Test
    void checkInclusion7() {
        final var s1 = "hello";
        final var s2 = "ooolleoooleh";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertFalse(result);
    }

    @Test
    void checkInclusion8() {
        final var s1 = "ab";
        final var s2 = "ab";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertTrue(result);
    }

    @Test
    void checkInclusion9() {
        final var s1 = "hello";
        final var s2 = "hello";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertTrue(result);
    }

    @Test
    void checkInclusion10() {
        final var s1 = "adc";
        final var s2 = "dcda";
        final var result = PermutationInString.checkInclusion(s1, s2);

        assertTrue(result);
    }
}