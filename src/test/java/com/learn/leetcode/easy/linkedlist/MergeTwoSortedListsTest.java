package com.learn.leetcode.easy.linkedlist;

import com.learn.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    @Test
    void mergeTwoLists1() {
         final var listNode1 = ListNode.of(new int[]{1, 2, 4});
         final var listNode2 = ListNode.of(new int[]{1, 3, 4});
         final var expectedList = ListNode.of(new int[]{1, 1, 2, 3, 4, 4});

         final var mergedListNode = MergeTwoSortedLists.mergeTwoLists(listNode1, listNode2);

         final var result = ListNode.toStringFrom(mergedListNode);
         final var expected = ListNode.toStringFrom(expectedList);

         assertEquals(expected, result);
    }

    @Test
    void mergeTwoLists2() {
        final var listNode1 = ListNode.of(new int[]{1, 2, 4});
        final var listNode2 = ListNode.of(new int[]{5, 6, 7});
        final var expectedList = ListNode.of(new int[]{1, 2, 4, 5, 6, 7});

        final var mergedListNode = MergeTwoSortedLists.mergeTwoLists(listNode1, listNode2);

        final var result = ListNode.toStringFrom(mergedListNode);
        final var expected = ListNode.toStringFrom(expectedList);

        assertEquals(expected, result);
    }

    @Test
    void mergeTwoLists3() {
        final var listNode1 = ListNode.of(new int[]{1, 50, 99});
        final var listNode2 = ListNode.of(new int[]{3, 51, 98});
        final var expectedList = ListNode.of(new int[]{1, 3, 50, 51, 98, 99});

        final var mergedListNode = MergeTwoSortedLists.mergeTwoLists(listNode1, listNode2);

        final var result = ListNode.toStringFrom(mergedListNode);
        final var expected = ListNode.toStringFrom(expectedList);

        assertEquals(expected, result);
    }
}