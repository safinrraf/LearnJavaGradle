package com.learn.leetcode.daily.w2024.q202410.medium;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/make-sum-divisible-by-p/description/?envType=daily-question&envId=2024-10-03">Task</a>
 * <a href="">Explanation</a>
 * <p>
 *     <li>Hint 1: Use prefix sums to calculate the subarray sums.
 *     <li>Hint 2: Suppose you know the remainder for the sum of the entire array. How does removing a subarray affect that remainder? What remainder does the subarray need to have in order to make the rest of the array sum up to be divisible by k?
 *     <li>Hint 3: Use a map to keep track of the rightmost index for every prefix sum % p.
 * </p>
 */
public final class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Find remainder when total sum is divided by p
        int rem = (int)(totalSum % p);
        if (rem == 0) {
            // If remainder is 0, no subarray needs to be removed
            return 0;
        }

        final HashMap<Integer, Integer> prefixMod = new HashMap<>();
        prefixMod.put(0, -1);  // Initialize to handle full prefix
        long prefixSum = 0;
        int minLength = nums.length;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];
            final int currentMod = (int)(prefixSum % p);
            final int targetMod = (currentMod - rem + p) % p;

            if (prefixMod.containsKey(targetMod)) {
                minLength = Math.min(minLength, i - prefixMod.get(targetMod));
            }

            prefixMod.put(currentMod, i);
        }

        return minLength == nums.length ? -1 : minLength;
    }
}
