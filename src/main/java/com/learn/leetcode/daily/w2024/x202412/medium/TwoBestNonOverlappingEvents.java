package com.learn.leetcode.daily.w2024.x202412.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/two-best-non-overlapping-events/description/?envType=daily-question&envId=2024-12-08">Task</a>
 * <br><a href="https://leetcode.com/problems/two-best-non-overlapping-events/solutions/6124334/100-beats-simple-binary-search/?envType=daily-question&envId=2024-12-08">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search, Dynamic Programming, Sorting, Heap (Priority Queue)}
 * </ul>
 * <ul>Hints
 * <li> {@code How can sorting the events on the basis of their start times help? How about end times?}
 * <li> {@code How can we quickly get the maximum score of an interval not intersecting with the interval we chose?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 2 <= events.length <= 10^5}
 * <li> {@code events[i].length == 3}
 * <li> {@code 1 <= startTime-i <= endTime-i <= 10^9}
 * <li> {@code 1 <= valuei <= 10^6}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 08.12.24 16:59
 */
public final class TwoBestNonOverlappingEvents {

    /**
     * {@code Time Complexity O(NLogN)}
     * {@code Space Complexity O(N)}
     *
     * @param events
     * @return the maximum sum.
     */
    public static int maxTwoEvents(int[][] events) {
        final int n = events.length;

        // Step 1: Sort the events by their start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        // Step 2: Create the suffix array for the maximum event value from each event onward
        final int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];  // Initialize the last event's value

        // Populate the suffixMax array
        for (int i = n - 2; i >= 0; --i) {
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
        }

        // Step 3: For each event, find the next event that starts after it ends
        int maxSum = 0;

        for (int i = 0; i < n; ++i) {
            int left = i + 1, right = n - 1;
            int nextEventIndex = -1;

            // Perform binary search to find the next non-overlapping event
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][0] > events[i][1]) {
                    nextEventIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // If a valid next event is found, update the max sum
            if (nextEventIndex != -1) {
                maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextEventIndex]);
            }

            // Also consider the case where we take only the current event
            maxSum = Math.max(maxSum, events[i][2]);
        }

        return maxSum;
    }
}
