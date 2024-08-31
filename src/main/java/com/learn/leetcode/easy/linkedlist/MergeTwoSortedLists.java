package com.learn.leetcode.easy.linkedlist;

import com.learn.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/">Task</a>
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var result = new ListNode();
        var temp = result;

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = new ListNode(list1.val);
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = new ListNode(list2.val);
                temp = temp.next;
                list2 = list2.next;
            }
        }

        temp.next = list1 != null ? list1 : list2;

        return result.next;
    }
}
