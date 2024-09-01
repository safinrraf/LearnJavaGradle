package com.learn.leetcode.easy.linkedlist;

import com.learn.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/">Task</a>
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/discuss/1137027/JS-Python-Java-C++-or-Easy-Floyd's-+-Reversal-Solution-w-Explanation">Explanation</a>
 */
public final class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
