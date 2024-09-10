package com.learn.leetcode.daily;

import com.learn.leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/?envType=daily-question&envId=2024-09-10">Task</a>
 */
public final class InsertGreatestCommonDivisorsInLinkedList {

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        var curr = head;

        while (curr != null) {
            if (curr.next == null) {
                break;
            }

            final var gcd = getBinaryGCD(curr.val, curr.next.val);
            var tmp = curr.next;
            curr.next = new ListNode(gcd);
            curr.next.next = tmp;
            curr = tmp;
        }

        return head;
    }

    // Function to return the GCD of two numbers
    public static int getGCD(int a, int b) {
        // Base case
        if (b == 0) {
            return a;
        }
        // Recursive case
        return getGCD(b, a % b);
    }

    // Function to return the GCD of two numbers using the Binary GCD algorithm
    public static int getBinaryGCD(int a, int b) {
        // Base cases
        if (a == 0) return b;
        if (b == 0) return a;

        // Find the greatest power of 2 that divides both a and b
        int commonPowerOfTwo = Integer.numberOfTrailingZeros(a | b);

        // Remove all factors of 2 from a
        a >>= Integer.numberOfTrailingZeros(a);

        while (b != 0) {
            // Remove all factors of 2 from b
            b >>= Integer.numberOfTrailingZeros(b);

            // Ensure a <= b
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            // Subtract a from b
            b = b - a;
        }

        // Restore the common power of 2
        return a << commonPowerOfTwo;
    }
}
