package com.learn.leetcode.daily.daily;

import com.learn.leetcode.daily.q202408.FindTheClosestPalindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheClosestPalindromeTest {

    @Test
    void nearestPalindromic1() {
        final var input = "123";
        final var expected = "121";

        assertEquals(expected, FindTheClosestPalindrome.nearestPalindromic(input));
    }

    @Test
    void nearestPalindromic2() {
        final var input = "1";
        final var expected = "0";

        assertEquals(expected, FindTheClosestPalindrome.nearestPalindromic(input));
    }

    @Test
    void nearestPalindromic3() {
        final var input = "11";
        final var expected = "9";

        assertEquals(expected, FindTheClosestPalindrome.nearestPalindromic(input));
    }

    @Test
    void nearestPalindromic4() {
        final var input = "3";
        final var expected = "2";

        assertEquals(expected, FindTheClosestPalindrome.nearestPalindromic(input));
    }

    @Test
    void nearestPalindromic5() {
        final var input = "12";
        final var expected = "11";

        assertEquals(expected, FindTheClosestPalindrome.nearestPalindromic(input));
    }
}