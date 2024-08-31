package com.learn.leetcode.easy.linkedlist;

import com.learn.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/">Task</a>
 */
public final class DeleteNodeInLinkedList {

    public static void deleteNode(ListNode node) {
        // Overwrite data of next node on current node.
        node.val = node.next.val;
        // Make current node point to next of next node.
        node.next = node.next.next;
    }
}
