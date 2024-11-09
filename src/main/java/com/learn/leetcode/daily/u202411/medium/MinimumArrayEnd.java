package com.learn.leetcode.daily.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/minimum-array-end/description/?envType=daily-question&envId=2024-11-09">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Bit Manipulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Each element of the array should be obtained by “merging” x and v where v = 0, 1, 2, …(n - 1).}
 * <li> {@code To merge x with another number v, keep the set bits of x untouched, for all the other bits, fill the set bits of v from right to left in order one by one.}
 * <li> {@code So the final answer is the “merge” of x and n - 1.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= n, x <= 10^8}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 09.11.24 15:38
 */
public final class MinimumArrayEnd {

    /**
     * {@code Time Complexity O(LogN)}
     * {@code Space Complexity O(1)}
     * @param n
     * @param x
     * @return the minimum possible value of {@code nums[n - 1] }.
     */
    public static long minEnd(int n, int x) {
        final int[] n1 = new int[64];
        final int[] n2 = new int[64];
        var result = 0L;

        var shift = 0;
        // the same for the second n - 1 (check the second hint)
        while(((n - 1) >> shift) > 0) {
            //Test if the n-th bit is set.
            if ((((n - 1) >> shift) & 1) == 1) {
                n2[64 - 1 - shift] = 1;
            }
            shift++;
        }

        // I am follow the Hints
        // So I make a "bit" representation of the number of the x
        shift = 0;
        while((x >> shift) > 0) {
            //Test if the n-th bit is set.
            if (((x >> shift) & 1) == 1) {
                n1[64 - 1 - shift] = 1;
            }
            shift++;
        }

        //here I do merging
        var n2_pos = 63;
        for(int i = 63; i >= 0; i--) {
            if(n1[i] == 0) {
                n1[i] = n2[n2_pos--];
            }
        }

        // and now the coolest thing
        // setting the bits
        for(int i = 63; i >= 0; i--) {
            if(n1[i] == 1) {
                result |= (1L << (63 - i) );
            }
        }

        return result;
    }

    public long minEndFasterAndNotMine(int n, int x) {
        long result = x;
        long mask;
        n--; // Reducing n by 1 to exclude x from the iteration

        // Step 1: Iterate over each bit position with mask starting at 1 and shifting left
        for (mask = 1; n > 0; mask <<= 1) {
            // Step 2: If the corresponding bit in x is 0
            if ((mask & x) == 0) {
                // Set the bit in result based on the least significant bit of n
                result |= (n & 1) * mask;
                // Shift n to the right by 1 to process the next bit
                n >>= 1;
            }
        }

        return result;
    }
}
