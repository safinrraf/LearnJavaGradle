package com.learn.leetcode.easy.linkedlist;

import com.learn.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

    @Test
    void isPalindrome1() {
        final var listNode1 = ListNode.of(new int[]{1, 2, 2, 1});

        assertTrue(PalindromeLinkedList.isPalindrome(listNode1));
    }

    @Test
    void isPalindrome2() {
        final var listNode1 = ListNode.of(new int[]{1, 2, 2});

        assertFalse(PalindromeLinkedList.isPalindrome(listNode1));
    }

    @Test
    void isPalindrome3() {
        final var listNode1 = ListNode.of(new int[]{2});

        assertTrue(PalindromeLinkedList.isPalindrome(listNode1));
    }

    @Test
    void isPalindrome4() {
        final var listNode1 = ListNode.of(new int[]{1,1,2,1});

        assertFalse(PalindromeLinkedList.isPalindrome(listNode1));
    }

    @Test
    void isPalindrome5() {
        final var listNode1 = ListNode.of(new int[]{1, 2, 3, 2, 1});

        assertTrue(PalindromeLinkedList.isPalindrome(listNode1));
    }

    @Test
    void isPalindrome6() {
        final var listNode1 = ListNode.of(new int[]{1, 3, 0, 2});

        assertFalse(PalindromeLinkedList.isPalindrome(listNode1));
    }
}