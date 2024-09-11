package com.learn.leetcode.daily;

import com.learn.leetcode.common.ListNode;
import com.learn.leetcode.daily.q202409.InsertGreatestCommonDivisorsInLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertGreatestCommonDivisorsInLinkedListTest {

    @Test
    void insertGreatestCommonDivisors1() {
        final var head = ListNode.of(new int[]{18, 6, 10, 3});
        final var expected = ListNode.of(new int[]{18, 6, 6, 2, 10, 1, 3});
        final var result = InsertGreatestCommonDivisorsInLinkedList.insertGreatestCommonDivisors(head);
        final var expectedString = ListNode.toStringFrom(expected);
        final var resultString = ListNode.toStringFrom(result);

        assertEquals(expectedString, resultString);
    }

    @Test
    void insertGreatestCommonDivisors2() {
        final var head = ListNode.of(new int[]{7});
        final var expected = ListNode.of(new int[]{7});
        final var result = InsertGreatestCommonDivisorsInLinkedList.insertGreatestCommonDivisors(head);
        final var expectedString = ListNode.toStringFrom(expected);
        final var resultString = ListNode.toStringFrom(result);

        assertEquals(expectedString, resultString);
    }
}