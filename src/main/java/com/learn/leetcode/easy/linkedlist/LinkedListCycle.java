package com.learn.leetcode.easy.linkedlist;

import com.learn.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/">Task</a>
 */
public final class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
