package com.learn.leetcode.daily.q202410.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/?envType=daily-question&envId=2024-10-30">Task</a>
 * <br><a href="https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/solutions/5984675/explained-step-by-step-beats-100-working-30-10-2024/?envType=daily-question&envId=2024-10-30">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search, Dynamic Programming, Greedy}
 * </ul>
 * <ul>Hints
 * <li> {@code Think the opposite direction instead of minimum elements to remove the maximum mountain subsequence.}
 * <li> {@code Think of LIS (Longest Increasing Subsequence) it's kind of close.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 3 <= nums.length <= 1000}
 * <li> {@code 1 <= nums[i] <= 10^9}
 * <li> {@code It is guaranteed that you can make a mountain array out of nums.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 30.10.24 09:18
 */
public final class MinimumNumberOfRemovalsToMakeMountainArray {

    /**
     *
     * @param nums
     * @return
     */
    public int minimumMountainRemovals(int[] nums) {
        int numsLen = nums.length;

        // Get LIS lengths from left to right (increasing part)
        final List<Integer> lis = lisLength(nums);

        // Get LIS lengths from right to left (decreasing part)
        final int[] reversed = new int[numsLen];
        for (int i = 0; i < numsLen; i++) {
            reversed[i] = nums[numsLen - 1 - i];
        }
        final List<Integer> lds = lisLength(reversed);
        Collections.reverse(lds);

        int removals = Integer.MAX_VALUE;

        // For each potential peak position
        for (int i = 0; i < numsLen; i++) {
            // Valid mountain needs both sides to have length > 1
            if (lis.get(i) > 1 && lds.get(i) > 1) {
                // Calculate removals needed:
                // Total length - (increasing length + decreasing length - 1)
                // -1 because peak is counted twice
                removals = Math.min(removals, numsLen + 1 - lis.get(i) - lds.get(i));
            }
        }

        return removals;
    }

    // Helper function to calculate LIS lengths for each position
    private List<Integer> lisLength(int[] nums) {
        // Start with first element
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        // Track LIS length ending at each position
        List<Integer> lisLen = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            lisLen.add(1);
        }

        for (int i = 1; i < nums.length; i++) {
            // If current element is larger than last LIS element, extend the sequence
            if (nums[i] > lis.get(lis.size() - 1)) {
                lis.add(nums[i]);
            } else {
                // Replace the smallest element that's >= current element
                // This maintains the potential for longer sequences
                int index = Collections.binarySearch(lis, nums[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                lis.set(index, nums[i]);
            }
            // Store length of LIS up to current position
            lisLen.set(i, lis.size());
        }
        return lisLen;
    }

    public static int lengthOfLDS(int[] nums) {
        // Edge case: if array is empty, LDS length is 0
        if (nums.length == 0) {
            return 0;
        }

        // Array to store the end values of the decreasing subsequences
        int[] tail = new int[nums.length];
        int length = 0; // Represents the length of the LDS

        for (int num : nums) {
            // To find the correct position, binary search in the reverse order
            int index = Arrays.binarySearch(tail, 0, length, -num);

            // If num is not found, binarySearch returns -(insertion_point) - 1
            if (index < 0) {
                index = -(index + 1);
            }

            // Update the tail array with num at the found index
            tail[index] = -num;

            // If num is added at the end of the tail array, increase the length
            if (index == length) {
                length++;
            }
        }

        return length;
    }
}
