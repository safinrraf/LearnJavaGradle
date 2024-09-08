package com.learn.leetcode.daily;

import com.learn.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitLinkedListInPartsTest {

    @Test
    void splitListToParts1() {
        final var listNode = ListNode.of(new int[]{1, 2, 3});
        final var k = 5;

        final var result = SplitLinkedListInParts.splitListToParts(listNode, k);

    }

    @Test
    void splitListToParts2() {
        final var listNode = ListNode.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        final var k = 3;

        final var result = SplitLinkedListInParts.splitListToParts(listNode, k);

    }

    @Test
    void splitListToParts3() {
        final var listNode = ListNode.of(new int[]{0, 2});
        final var k = 2;

        final var result = SplitLinkedListInParts.splitListToParts(listNode, k);

    }

    @Test
    void splitListToParts4() {
        final var listNode = ListNode.of(new int[]{0, 1, 2, 3});
        final var k = 2;

        final var result = SplitLinkedListInParts.splitListToParts(listNode, k);

    }
}