package com.learn.leetcode.easy.arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/">Task</a>
 */
public final class PlusOne {
    public static int[] plusOne(int[] digits) {
        var index = digits.length - 1;
        while (index >= 0){
            if (digits[index] == 9) {
                digits[index] = 0;
                index--;
            } else {
                digits[index]++;
                break;
            }
        }

        if (digits[0] == 0) {
            final var newArray = new int[digits.length + 1];
            newArray[0] = 1;
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            return newArray;
        }
        return digits;
    }
}
