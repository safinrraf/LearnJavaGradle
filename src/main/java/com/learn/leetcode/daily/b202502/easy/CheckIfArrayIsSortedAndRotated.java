package com.learn.leetcode.daily.b202502.easy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/?envType=daily-question&envId=2025-02-02">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array}
 * </ul>
 * <ul>Hints
 * <li> {@code Brute force and check if it is possible for a sorted array to start from each position.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 100}
 * <li> {@code 1 <= nums[i] <= 100}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 02.02.25 09:48
 */
public final class CheckIfArrayIsSortedAndRotated {

    /**
     *
     * <p>
     * {@code Time Complexity O(2*N)}<br>
     * {@code Space Complexity O(2*N)}
     * </p>
     * @param nums an array of integers.
     * @return {@code true} if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return {@code false}.
     */
    public static boolean check(int[] nums) {
        final int[] nums2 = new int[nums.length * 2];
        System.arraycopy(nums, 0, nums2, 0, nums.length);
        System.arraycopy(nums, 0, nums2, nums.length, nums.length);

        for(int i = 1; i < nums2.length; i++) {
            if(nums2[i - 1] > nums2[i]) {
                for(int j = i; j < nums.length + i - 1; j++) {
                    if(nums2[j] > nums2[j + 1]) {
                        return false;
                    }
                }
                return true;
            }
        }

        return true;
    }

    /**
     *
     * <p>
     * {@code Time Complexity O(N^2)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param nums an array of integers.
     * @return {@code true} if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return {@code false}.
     */
    public static boolean check2(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] > nums[i]) {
                for(int j = 0; j < nums.length - 1; j++) {
                    if(nums[(i + j) % nums.length] > nums[(i + j + 1) % nums.length]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }
}
