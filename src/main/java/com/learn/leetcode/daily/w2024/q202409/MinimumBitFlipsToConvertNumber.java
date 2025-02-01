package com.learn.leetcode.daily.w2024.q202409;

/**
 * <a href="https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/?envType=daily-question&envId=2024-09-11">Task</a>
 */
public final class MinimumBitFlipsToConvertNumber {

    public static int minBitFlips(int start, int goal) {
        int ans = 0;
        // XOR will give 1 where the bits are different
        int xor = start ^ goal;

        while(xor!=0){
            // If the last bit is 1, increment count
            ans += xor & 1;

            // Right-shift to check the next bit
            xor >>=1;
        }
        return ans;
    }
}
