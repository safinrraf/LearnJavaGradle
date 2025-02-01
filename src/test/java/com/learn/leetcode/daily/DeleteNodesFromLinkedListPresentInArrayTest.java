package com.learn.leetcode.daily;

import com.learn.leetcode.common.ListNode;
import com.learn.leetcode.daily.w2024.q202409.DeleteNodesFromLinkedListPresentInArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodesFromLinkedListPresentInArrayTest {

    @Test
    void modifiedList1() {
        final var listNode = ListNode.of(new int[]{1, 2, 3, 4, 5});
        final var expected = ListNode.of(new int[]{4, 5});
        final var nums = new int[]{1, 2, 3};

        final var result = DeleteNodesFromLinkedListPresentInArray.modifiedList(nums, listNode);

        final var resultString = ListNode.toStringFrom(result);
        final var expectedString = ListNode.toStringFrom(expected);

        assertEquals(expectedString, resultString);
    }

    @Test
    void modifiedList2() {
        final var listNode = ListNode.of(new int[]{1, 2, 1, 2, 1, 2});
        final var expected = ListNode.of(new int[]{2, 2, 2});
        final var nums = new int[]{1};

        final var result = DeleteNodesFromLinkedListPresentInArray.modifiedList(nums, listNode);

        final var resultString = ListNode.toStringFrom(result);
        final var expectedString = ListNode.toStringFrom(expected);

        assertEquals(expectedString, resultString);
    }

    @Test
    void modifiedList3() {
        final var listNode = ListNode.of(new int[]{1, 2, 3, 4});
        final var expected = ListNode.of(new int[]{1, 2, 3, 4});
        final var nums = new int[]{5};

        final var result = DeleteNodesFromLinkedListPresentInArray.modifiedList(nums, listNode);

        final var resultString = ListNode.toStringFrom(result);
        final var expectedString = ListNode.toStringFrom(expected);

        assertEquals(expectedString, resultString);
    }
}