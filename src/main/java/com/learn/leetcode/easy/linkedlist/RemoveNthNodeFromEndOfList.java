package com.learn.leetcode.easy.linkedlist;

import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/603/">Task</a>
 */
@Slf4j
public final class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (n-- != 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static class ListNode {
        int val;
        public ListNode next;
        ListNode() {}
        public ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}