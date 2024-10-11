package com.learn.leetcode.daily.q202410;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/maximum-width-ramp/description/?envType=daily-question&envId=2024-10-10">Task</a>
 * <br><a href="">Explanation</a>
 * <p>
 * <br>@since 1.0.0
 * <br> 10.10.24 13:16
 * </p>
 */
public final class MaximumWidthRamp {
    /**
     * Topic {@code Array, Stack, Monotonic Stack}
     * @param nums
     * @return
     */
    public int maxWidthRamp(int[] nums) {
        final int n = nums.length;
        final Stack<Integer> stack = new Stack<>();

        // Step 1: Build a decreasing stack of indices
        for (int i = 0; i < n; ++i) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        // Step 2: Traverse from the end and find maximum width ramp
        for (int j = n - 1; j >= 0; --j) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }

        return maxWidth;
    }
}
