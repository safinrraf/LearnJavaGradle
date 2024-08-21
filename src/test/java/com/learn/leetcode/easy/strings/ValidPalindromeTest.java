package com.learn.leetcode.easy.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    void isPalindrome1() {
        final var intput = "A man, a plan, a canal: Panama";

        assertTrue(ValidPalindrome.isPalindrome(intput));
    }

    @Test
    void isPalindrome2() {
        final var intput = "race a car";

        assertFalse(ValidPalindrome.isPalindrome(intput));
    }

    @Test
    void isPalindrome3() {
        final var intput = ".,";

        assertTrue(ValidPalindrome.isPalindrome(intput));
    }

    @Test
    void isPalindrome4() {
        final var intput = "AbcCBa";

        assertTrue(ValidPalindrome.isPalindrome(intput));
    }

    @Test
    void isPalindrome5() {
        final var intput = "Abc.CBa";

        assertTrue(ValidPalindrome.isPalindrome(intput));
    }

    @Test
    void isPalindrome6() {
        final var intput = "0P";

        assertFalse(ValidPalindrome.isPalindrome(intput));
    }
}