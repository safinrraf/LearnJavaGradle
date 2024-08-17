package com.learn.leetcode.easy.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/">Task</a>
 */
public final class TwoSum {
    /**
     * Accepted.
     */
    public static int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        final var result = new int[2];
        var stopScan = false;
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (var entry : map.entrySet()) {
            final var value = target - entry.getValue();
            if(map.containsValue(value)) {
                result[0] = entry.getKey();

                for (var entry2 : map.entrySet()) {
                    if (entry2.getValue().equals(value) && !entry.getKey().equals(entry2.getKey())) {
                        result[1] = entry2.getKey();
                        stopScan = true;
                        break;
                    }
                }
            }
            if(stopScan) {
                break;
            }
        }
        return result;
    }

    public static int[] twoSumNotMy(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0;; ++i) {
            int x = nums[i];
            int y = target - x;
            if (m.containsKey(y)) {
                return new int[] {m.get(y), i};
            }
            m.put(x, i);
        }
    }

}
