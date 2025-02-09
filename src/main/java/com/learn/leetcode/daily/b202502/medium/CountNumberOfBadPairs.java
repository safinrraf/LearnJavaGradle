package com.learn.leetcode.daily.b202502.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/count-number-of-bad-pairs/description/?envType=daily-question&envId=2025-02-09">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Math, Counting}
 * </ul>
 * <ul>Hints
 * <li> {@code Would it be easier to count the number of pairs that are not bad pairs?}
 * <li> {@code Notice that (j - i != nums[j] - nums[i]) is the same as (nums[i] - i != nums[j] - j).}
 * <li> {@code Keep a counter of nums[i] - i. To be efficient, use a HashMap.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 10^5}
 * <li> {@code 1 <= nums[i] <= 10^9}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 09.02.25 16:44
 */
public final class CountNumberOfBadPairs {

    /**
     * LTE :)
     * <p>
     * {@code Time Complexity O(N^2)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param nums a 0-indexed integer array.
     * @return the total number of bad pairs in {@code nums}.
     */
    public static long countBadPairsLTE(int[] nums) {
        long answer = 0;
        for(int i = 0; i < nums.length; i++) {
            final int start = i + 1;
            for(int j = start; j < nums.length; j++) {
                if(nums[i] - i != nums[j] - j) {
                   answer++;
                }
            }
        }

        return answer;
    }

    /**
     *
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param nums a 0-indexed integer array.
     * @return the total number of bad pairs in {@code nums}.
     */
    public static long countBadPairs(int[] nums) {
        //Formula for Total Pairs
        long totalPairs = (long) nums.length * (nums.length - 1) / 2;
        long goodPairs = 0;
        final HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            //If nums[i] - i has appeared before, those are good pairs.
            goodPairs += freqMap.getOrDefault(key, 0);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }

        return totalPairs - goodPairs; // Bad pairs = Total pairs - Good pairs
    }
}
