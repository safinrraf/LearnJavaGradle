package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.u202411.hard.ShortestSubarrayWithSumAtLeastK;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/?envType=daily-question&envId=2024-11-19">Task</a>
 * <br><a href="https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/solutions/6060159/beats-100-video-list-most-common-array-interview/?envType=daily-question&envId=2024-11-19">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Sliding Window}
 * </ul>
 * <ul>Hints
 * <li> {@code Which elements change when moving from the subarray of size k that ends at index i to the subarray of size k that ends at index i + 1?}
 * <li> {@code Only two elements change, the element at i + 1 is added into the subarray, and the element at i - k + 1 gets removed from the subarray.}
 * <li> {@code Iterate through each subarray of size k and keep track of the sum of the subarray and the frequency of each element.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= k <= nums.length <= 10^5}
 * <li> {@code 1 <= nums[i] <= 10^5}
 * </ul>
 * <br>@since 1.0.0
 * <br> 19.11.24 08:19
 */
public final class MaximumSumOfDistinctSubarraysWithLengthK {

    /**
     * {@code Time Complexity O(..)}
     * {@code Space Complexity O(..)}
     *
     * <p>A <b>sub-array</b> is a contiguous non-empty sequence of elements within an array.</p>
     *
     * @param nums an integer array.
     * @param k the length of sub-array.
     * @return the maximum sub-array sum of all the sub-arrays that meet the conditions.
     */
    public static long maximumSubarraySumTLE(int[] nums, int k) {
        var result = 0L;
        final Set<Integer> set = new HashSet<>();

        for(int i = 0; i <= nums.length - k; i++) {
            var tmp_sum = 0L;
            set.clear();
            for(int j = i; j < i + k; j++) {
                if(!set.contains(nums[j])) {
                    set.add(nums[j]);
                    tmp_sum += nums[j];
                } else {
                    tmp_sum = 0L;
                    break;
                }
            }
            if(set.size() == k) {
                result = Math.max(result, tmp_sum);
            }
        }

        return result;
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> elements = new HashSet<>();
        long currentSum = 0;
        long maxSum = 0;
        int begin = 0;

        for (int end = 0; end < n; end++) {
            if (!elements.contains(nums[end])) {
                currentSum += nums[end];
                elements.add(nums[end]);

                if (end - begin + 1 == k) {
                    maxSum = Math.max(maxSum, currentSum);
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
            } else {
                while (nums[begin] != nums[end]) {
                    currentSum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }

        return maxSum;
    }
}
