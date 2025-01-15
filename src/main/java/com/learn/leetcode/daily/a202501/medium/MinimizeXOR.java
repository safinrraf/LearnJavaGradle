package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/minimize-xor/description/?envType=daily-question&envId=2025-01-15">Task</a>
 * <br><a href="https://leetcode.com/problems/minimize-xor/editorial/?envType=daily-question&envId=2025-01-15">Explanation</a>
 * <ul>Topics
 * <li> {@code Greedy, Bit Manipulation}
 * </ul>
 * <ul>Hints
 * <li> {@code To arrive at a small xor, try to turn off some bits from num1}
 * <li> {@code If there are still left bits to set, try to set them from the least significant bit}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= num1, num2 <= 10^9}
 * </ul>
 * <br>@since 1.0.0
 * <br> 15.01.25 08:14
 */
public final class MinimizeXOR {

    /**
     * Approach 1: From Optimal to Valid
     * <p>
     * {@code Time Complexity O(LogN)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param num1
     * @param num2
     * @return
     */
    public static int minimizeXor(int num1, int num2) {
        // Initialize result to num1. We will modify result.
        int result = num1;

        final int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = Integer.bitCount(result);

        // Start with the least significant bit (bit 0).
        int currentBit = 0;

        // Add bits to result if it has fewer set bits than the target.
        while (setBitsCount < targetSetBitsCount) {
            // If the current bit in result is not set (0), set it to 1.
            if (!isSet(result, currentBit)) {
                result = setBit(result, currentBit);
                setBitsCount++;
            }
            // Move to the next bit.
            currentBit++;
        }

        // Remove bits from result if it has more set bits than the target.
        while (setBitsCount > targetSetBitsCount) {
            // If the current bit in result is set (1), unset it (make it 0).
            if (isSet(result, currentBit)) {
                result = unsetBit(result, currentBit);
                setBitsCount--;
            }
            // Move to the next bit.
            currentBit++;
        }

        return result;
    }

    // Helper function to check if the given bit position in result is set (1).
    private static boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    // Helper function to set the given bit position in result to 1.
    private static int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    // Helper function to unset the given bit position in x (set it to 0).
    private static int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }
}
