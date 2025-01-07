package com.learn.leetcode.daily.a202501.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringMatchingInAnArrayTest {

    @Test
    void stringMatching1() {
        final String[] words = {"mass","as","hero","superhero"};
        final List<String> expected = List.of("as","hero");
        final List<String> result = StringMatchingInAnArray.stringMatching(words);

        assertEquals(expected, result);
    }

    @Test
    void stringMatching2() {
        final String[] words = {"leetcode","et","code"};
        final List<String> expected = List.of("et","code");
        final List<String> result = StringMatchingInAnArray.stringMatching(words);

        assertEquals(expected, result);
    }

    @Test
    void stringMatching3() {
        final String[] words = {"blue","green","bu"};
        final List<String> expected = List.of();
        final List<String> result = StringMatchingInAnArray.stringMatching(words);

        assertEquals(expected, result);
    }

    @Test
    void stringMatching4() {
        final String[] words = {"a","b","c"};
        final List<String> expected = List.of();
        final List<String> result = StringMatchingInAnArray.stringMatching(words);

        assertEquals(expected, result);
    }

    @Test
    void stringMatching5() {
        final String[] words = {"abc","abcdef","abcdefgh"};
        final List<String> expected = List.of("abc", "abcdef");
        final List<String> result = StringMatchingInAnArray.stringMatching(words);

        assertEquals(expected, result);
    }
}