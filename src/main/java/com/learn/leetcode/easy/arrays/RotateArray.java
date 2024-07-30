package com.learn.leetcode.easy.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/">Task</a>
 * */
@Slf4j
public class RotateArray {

    /**
     * Almost cool: result: Time Limit Exceeded.
     * */
    public static void rotateSlow(int[] nums, int k) {
        while (k != 0) {
            for (int i = 1; i < nums.length; i++) {
                nums[0] = nums[0] ^ nums[i];
                nums[i] = nums[0] ^ nums[i];
                nums[0] = nums[0] ^ nums[i];
            }
            k--;
        }
    }

    /**
     * Accepted.
     * */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int shift = k % len;
        reverse(nums, 0, len-shift-1);
        reverse(nums, len-shift, len-1);
        reverse(nums, 0, len-1);
    }

    public static void reverse(int nums[], int start, int end) {
        while(start < end) {
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start] ^ nums[end];
            start++;
            end--;
        }
    }

    public static int findGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return findGcd(b, a % b);
        }
    }
}
