package com.learn.leetcode.easy.strings;

import com.learn.leetcode.easy.strings.ValidAnagram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    @Test
    void isAnagram1() {
        final var s = "anagram";
        final var t = "nagaram";

        assertTrue(ValidAnagram.isAnagram(s, t));
    }

    @Test
    void isAnagram2() {
        final var s = "rat";
        final var t = "car";

        assertFalse(ValidAnagram.isAnagram(s, t));
    }
}