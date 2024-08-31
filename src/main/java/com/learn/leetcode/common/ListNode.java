package com.learn.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int[] input) {
        if (input.length == 0) {
            return new ListNode();
        }

        var head = new ListNode(input[0]);
        var item = head;
        for (var i = 1; i < input.length; i++) {
            item.next = new ListNode(input[i]);
            item = item.next;
        }

        return head;
    }

    public static String toStringFrom(ListNode head) {
        var tmp = head;
        final var result = new StringBuilder();
        while(tmp != null) {
            result.append(tmp.val);

            tmp = tmp.next;
            if (tmp != null) {
                result.append("->");
            }
        }
        return result.toString();
    }
}
