package com.learn.leetcode.daily.q202410.medium;

/**
 * <a href="https://leetcode.com/problems/maximum-swap/description/?envType=daily-question&envId=2024-10-17">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-swap/solutions/5922945/beats-100-00-step-by-step-breakdown/">Explanation</a>
 * <ul>Topics
 * <li> {@code Math, Greedy}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 17.10.24 08:47
 */
public final class MaximumSwap {

    /**
     *
     * @param num You are given an integer num. You can swap two digits at most once to get the maximum valued number.
     * @return Return the maximum valued number you can get.
     */
    public static int maximumSwap(int num) {
        // Convert number to string for digit manipulation
        final char[] numArr = Integer.toString(num).toCharArray();
        int length = numArr.length;

        // Track the last occurrence of each digit (0-9)
        int[] last = new int[10];
        for (int i = 0; i < length; i++) {
            last[numArr[i] - '0'] = i;
        }

        // Traverse the number from left to right
        for (int i = 0; i < length; i++) {
            // Check if we can find a larger digit to swap
            for (int d = 9; d > numArr[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap and return the new number
                    final var temp = numArr[i];
                    numArr[i] = numArr[last[d]];
                    numArr[last[d]] = temp;
                    return Integer.parseInt(new String(numArr));
                }
            }
        }

        // Return the original number if no swap occurred
        return num;
    }
}
