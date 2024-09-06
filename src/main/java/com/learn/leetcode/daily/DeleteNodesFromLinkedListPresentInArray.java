package com.learn.leetcode.daily;

import com.learn.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/?envType=daily-question&envId=2024-09-06">Task</a>
 */
public final class DeleteNodesFromLinkedListPresentInArray {

    public static ListNode modifiedList(int[] nums, ListNode head) {
        final Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        final var dummy = new ListNode();
        var ptr = dummy;
        while (head != null) {
            if(!numsSet.contains(head.val)) {
                ptr.next = new ListNode(head.val);
                ptr = ptr.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
