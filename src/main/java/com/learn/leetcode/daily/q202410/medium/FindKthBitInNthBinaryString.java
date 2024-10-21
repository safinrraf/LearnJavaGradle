package com.learn.leetcode.daily.q202410.medium;

/**
 * <a href="https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/?envType=daily-question&envId=2024-10-19">Task</a>
 * <br><a href="https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/solutions/5934232/beats-100-00-step-by-step-breakdown/?envType=daily-question&envId=2024-10-19">Explanation</a>
 * <ul>Topics
 * <li> {@code String, Recursion, Simulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Since n is small, we can simply simulate the process of constructing S1 to Sn.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= n <= 20}
 * <li> {@code 1 <= k <= 2n - 1}
 * </ul>
 * <br>@since 1.0.0
 * <br> 19.10.24 19:52
 */
public final class FindKthBitInNthBinaryString {
    /**
     * {@code Time Complexity O(N)}
     * <br>{@code Space Complexity O(N)} due to the recursion stack.
     * @param n
     * @param k
     * @return
     */
    public static char findKthBit(int n, int k) {
        if(k == 0) {
            return '0';
        }
        // Find the length of the current string Sn, which is 2^n - 1
        final var length = (1 << n) - 1;
        if(length == k) {
            return '1';
        }
        // Find the middle position
        var mid = length / 2 + 1;

        // If k is the middle position, return '1'
        if (k == mid) {
            return '1';
        }

        // If k is in the first half, find the bit in Sn-1
        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        // If k is in the second half, find the bit in Sn-1 and invert it
        return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0';
    }
}
