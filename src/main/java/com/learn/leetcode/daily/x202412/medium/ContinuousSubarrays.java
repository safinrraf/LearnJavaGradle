package com.learn.leetcode.daily.x202412.medium;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/continuous-subarrays/description/?envType=daily-question&envId=2024-12-14">Task</a>
 * <br><a href="https://leetcode.com/problems/continuous-subarrays/solutions/6140505/continuous-subarrays/?envType=daily-question&envId=2024-12-14">Explanation</a>
 * <ul>Topics
 * <li> {@code Sliding Window, Array, Ordered Set, Queue, Heap (Priority Queue), Monotonic Queue, Two Pointers}
 * <li> {@code Ordered Map, Hash Table, Dynamic Programming, Counting, Math, Binary Search Tree, Segment Tree, Tree, Stack}
 * <li> {@code Binary Search, Monotonic Stack, Memoization, Iterator, Greedy, Depth-First Search, Recursion}
 * </ul>
 * <ul>Hints
 * <li> {@code Try using the sliding window technique.}
 * <li> {@code Use a set or map to keep track of the maximum and minimum of subarrays.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 10^5}
 * <li> {@code 1 <= nums[i] <= 10^9}
 * </ul>
 * <br>@since 1.0.0
 * <br> 14.12.24 14:37
 */
public final class ContinuousSubarrays {

    /**
     * <p>Approach 1: Sorted Map</p>
     * <p>A sub-array is a contiguous non-empty sequence of elements within an array.</p>
     * <p>
     * {@code Time Complexity O(NLogK)≈O(N)}<br>
     * {@code Space Complexity O(K)≈O(1)}
     * </p>
     * @param nums a 0-indexed integer array.
     * @return the total number of continuous sub-arrays.
     */
    public static long continuousSubarrays_SortedMap(int[] nums) {
        // TreeMap to maintain sorted frequency map of current window
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int left = 0, right = 0;
        int n = nums.length;
        long count = 0; // Total count of valid subarrays

        while (right < n) {
            // Add current element to frequency map
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // While window violates the condition |nums[i] - nums[j]| ≤ 2
            // Shrink window from left
            while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
                // Remove leftmost element from frequency map
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            // Add count of all valid subarrays ending at right
            count += right - left + 1;
            right++;
        }

        return count;
    }

    /**
     *
     * <p>
     * {@code Time Complexity O(NLogN)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param nums
     * @return
     */
    public static long continuousSubarrays_PriorityQueue(int[] nums) {
        int left = 0, right = 0;
        long count = 0; // Total count of valid subarrays

        // Min and max heaps storing indices, sorted by nums[index] values
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> nums[a])
        );
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> nums[b] - nums[a]
        );

        while (right < nums.length) {
            // Add current index to both heaps
            minHeap.add(right);
            maxHeap.add(right);

            // While window violates |nums[i] - nums[j]| ≤ 2 condition
            // Shrink window from left and remove outdated indices
            while (
                    left < right && nums[maxHeap.peek()] - nums[minHeap.peek()] > 2
            ) {
                left++;

                // Remove indices that are now outside window
                while (!maxHeap.isEmpty() && maxHeap.peek() < left) {
                    maxHeap.poll();
                }
                while (!minHeap.isEmpty() && minHeap.peek() < left) {
                    minHeap.poll();
                }
            }

            // Add count of all valid subarrays ending at right
            count += right - left + 1;
            right++;
        }

        return count;
    }

    /**
     *
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param nums
     * @return
     */
    public static long continuousSubarrays_MonotonicDeque(int[] nums) {
        // Monotonic deque to track maximum and minimum elements
        final Deque<Integer> maxQ = new ArrayDeque<>();
        final Deque<Integer> minQ = new ArrayDeque<>();
        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain decreasing monotonic queue for maximum values
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[right]) {
                maxQ.pollLast();
            }
            maxQ.offerLast(right);

            // Maintain increasing monotonic queue for minimum values
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[right]) {
                minQ.pollLast();
            }
            minQ.offerLast(right);

            // Shrink window if max-min difference exceeds 2
            while (
                    !maxQ.isEmpty() &&
                            !minQ.isEmpty() &&
                            nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > 2
            ) {
                // Move left pointer past the element that breaks the condition
                if (maxQ.peekFirst() < minQ.peekFirst()) {
                    left = maxQ.peekFirst() + 1;
                    maxQ.pollFirst();
                } else {
                    left = minQ.peekFirst() + 1;
                    minQ.pollFirst();
                }
            }

            // Add count of all valid subarrays ending at current right pointer
            count += right - left + 1;
        }
        return count;
    }

    /**
     *
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param nums
     * @return
     */
    public long continuousSubarrays_OptimizedTwoPointer(int[] nums) {
        int right = 0, left = 0;
        int curMin, curMax;
        long windowLen = 0, total = 0;

        // Initialize window with first element
        curMin = curMax = nums[right];

        for (right = 0; right < nums.length; right++) {
            // Update min and max for current window
            curMin = Math.min(curMin, nums[right]);
            curMax = Math.max(curMax, nums[right]);

            // If window condition breaks (diff > 2)
            if (curMax - curMin > 2) {
                // Add subarrays from previous valid window
                windowLen = right - left;
                total += ((windowLen * (windowLen + 1)) / 2);

                // Start new window at current position
                left = right;
                curMin = curMax = nums[right];

                // Expand left boundary while maintaining condition
                while (
                        left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2
                ) {
                    left--;
                    curMin = Math.min(curMin, nums[left]);
                    curMax = Math.max(curMax, nums[left]);
                }

                // Remove overcounted subarrays if left boundary expanded
                if (left < right) {
                    windowLen = right - left;
                    total -= ((windowLen * (windowLen + 1)) / 2);
                }
            }
        }

        // Add subarrays from final window
        windowLen = right - left;
        total += ((windowLen * (windowLen + 1)) / 2);

        return total;
    }
}
