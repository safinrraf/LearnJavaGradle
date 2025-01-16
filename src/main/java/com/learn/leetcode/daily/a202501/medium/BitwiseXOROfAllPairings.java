package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/bitwise-xor-of-all-pairings/description/?envType=daily-question&envId=2025-01-16">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Bit Manipulation, Brainteaser}
 * </ul>
 * <ul>Hints
 * <li> {@code Think how the count of each individual integer affects the final answer.}
 * <li> {@code If the length of nums1 is m and the length of nums2 is n, then each number in nums1 is repeated n times and each number in nums2 is repeated m times.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums1.length, nums2.length <= 10^5}
 * <li> {@code 0 <= nums1[i], nums2[j] <= 10^9}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 16.01.25 08:24
 */
public final class BitwiseXOROfAllPairings {

    /**
     * Approach 2: Space Optimized Bit Manipulation.
     * <p>
     * {@code Time Complexity O(N + M)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param nums1 0-indexed array.
     * @param nums2 0-indexed array.
     * @return the <b>bitwise XOR</b> of all integers in {@code nums3}.
     */
    public static int xorAllNums(int[] nums1, int[] nums2) {
        // Initialize XOR results for both arrays
        int xor1 = 0;
        int xor2 = 0;

        // Get lengths of both arrays
        final int len1 = nums1.length;
        final int len2 = nums2.length;

        // If nums2 length is odd, each element in nums1 appears odd times in final result
        if (len2 % 2 != 0) {
            for (int num : nums1) {
                xor1 ^= num;
            }
        }

        // If nums1 length is odd, each element in nums2 appears odd times in final result
        if (len1 % 2 != 0) {
            for (int num : nums2) {
                xor2 ^= num;
            }
        }

        // Return XOR of both results
        return xor1 ^ xor2;
    }
}
