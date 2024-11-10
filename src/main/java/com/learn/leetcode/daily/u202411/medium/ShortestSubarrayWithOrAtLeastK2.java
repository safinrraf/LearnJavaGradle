package com.learn.leetcode.daily.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description/?envType=daily-question&envId=2024-11-10">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Bit Manipulation, Sliding Window}
 * </ul>
 * <ul>Hints
 * <li> {@code For each nums[i], we can maintain each sub-array’s bitwise OR result ending with it.}
 * <li> {@code The property of bitwise OR is that it never unsets any bits and only sets new bits.}
 * <li> {@code So the number of different results for each nums[i] is at most the number of bits 32.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 2 * 10^5}
 * <li> {@code 0 <= nums[i] <= 10^9}
 * <li> {@code 0 <= k <= 109}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 10.11.24 15:34
 */
public final class ShortestSubarrayWithOrAtLeastK2 {

    /**
     * {@code Time Complexity O(N*32)}
     * {@code Space Complexity O(1)}
     *
     * @param nums array of non-negative integers.
     * @param k control number. An array is called special if the bitwise {@code OR} of all of its elements is at least {@code k}.
     * @return the length of the <b>shortest special non-empty sub-array</b> of {@code nums}, or return {@code -1} if no special sub-array exists.
     */
    public static int minimumSubarrayLength(int[] nums, int k) {
        final int[] bitCount = new int[32];
        int currentOR = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            currentOR |= nums[right];

            for (int bit = 0; bit < 32; bit++) {
                if ((nums[right] & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }

            while (left <= right && currentOR >= k) {
                minLength = Math.min(minLength, right - left + 1);

                int updatedOR = 0;
                for (int bit = 0; bit < 32; bit++) {
                    if ((nums[left] & (1 << bit)) != 0) {
                        bitCount[bit]--;
                    }
                    if (bitCount[bit] > 0) {
                        updatedOR |= (1 << bit);
                    }
                }
                currentOR = updatedOR;
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static int minimumSubarrayLengthMineButLTE(int[] nums, int k) {
        int ans = Integer.MAX_VALUE, curr, right;

        for (int left = 0; left < nums.length; left++) {
            right = 0;
            while (right <= left) {
                curr = nums[left];
                for (int j = right; j <= left; j++) {
                    curr |= nums[j];
                }
                if(curr >= k) {
                    ans = Math.min(left - right + 1, ans);
                }
                right++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
