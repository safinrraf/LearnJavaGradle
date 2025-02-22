package com.learn.leetcode.daily.w2024.q202409;

/**
 * <a href="https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/?envType=daily-question&envId=2024-09-03">Task</a>
 */
public final class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        int sum = 0;
        // Calculate the initial sum directly from the string
        for (char i : s.toCharArray()) {
            int value = i - 'a' + 1;  // Direct calculation without HashMap
            // Convert number to string to add digits, e.g., 'a' -> "1"
            while (value > 0) {
                sum += value % 10;  // Add each digit to sum
                value /= 10;
            }
        }

        // Perform the transformations k times
        while (k-- > 1) {  // We already calculated the initial sum once
            int newSum = 0;
            while (sum > 0) {
                newSum += sum % 10;  // Add each digit to newSum
                sum /= 10;
            }
            sum = newSum;
        }
        return sum;
    }
}
