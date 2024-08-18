package com.learn.leetcode.easy.strings.ReverseString;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/">Task</a>
 */
public final class ReverseInteger {
    public static int reverse(int x) {
        long reversedNumber = 0;
        int digit;
        while (x != 0) {
            digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            if(reversedNumber < Integer.MIN_VALUE || reversedNumber > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }

        return (int) reversedNumber;
    }
}
