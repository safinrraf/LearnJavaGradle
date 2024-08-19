package com.learn.leetcode.easy.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueCharacterInStringTest {

    @Test
    void firstUniqChar1() {
        final var input = "leetcode";
        final var expected = 0;
        final var result = FirstUniqueCharacterInString.firstUniqChar(input);

        assertEquals(expected, result);
    }

    @Test
    void firstUniqChar2() {
        final var input = "loveleetcode";
        final var expected = 2;
        final var result = FirstUniqueCharacterInString.firstUniqChar(input);

        assertEquals(expected, result);
    }

    @Test
    void firstUniqChar3() {
        final var input = "aabb";
        final var expected = -1;
        final var result = FirstUniqueCharacterInString.firstUniqChar(input);

        assertEquals(expected, result);
    }

    @Test
    void firstUniqChar4() {
        final var input = "aabbc";
        final var expected = 4;
        final var result = FirstUniqueCharacterInString.firstUniqChar(input);

        assertEquals(expected, result);
    }
}