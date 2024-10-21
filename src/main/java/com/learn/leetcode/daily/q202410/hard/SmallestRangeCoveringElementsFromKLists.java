package com.learn.leetcode.daily.q202410.hard;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/?envType=daily-question&envId=2024-10-13">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Greedy, Sliding Window, Sorting, Heap (Priority Queue)}
 * </ul>
 * <p>
 * <ul><b>Companies</b>:
 * <li> {@code Amazon, Flipkart}
 * </ul>
 * </p>
 * <p>
 *     <ul><b>Approach</b>:
 *     <li> # 1: merging k sorted arrays using priority queue, and mark down the group that each number is associated with
 *     <ul>
 *         <li> ...
 *     </ul>
 *     <li> # 2: Then we can take a sliding window approach to find the smallest range that covers all groups.
 *     <ul>
 *         <li> ...
 *     </ul>
 *     </ul>
 * </p>
 * <p>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br>13.10.24 11:51
 * </p>
 */
public final class SmallestRangeCoveringElementsFromKLists {

    private record Element(int value, int listIndex, int elementIndex){}

    /**
     * <p>Time complexity {@code O(NLogK)}</p>
     * <p>Space complexity {@code O(K)}</p>
     * @param nums List of Lists
     * @return Smallest Range Covering Elements from K Lists
     */
    public static int[] smallestRange(List<List<Integer>> nums) {
        final PriorityQueue<Element> min_heap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        int cur_max = Integer.MIN_VALUE;

        // Initialize the heap with the first element of each array
        // because each list is an ordered list, and my task is "Smallest Range Covering Elements from K Lists"
        for (int i = 0; i < nums.size(); i++) {
            if (!nums.get(i).isEmpty()) {
                final var first_element = nums.get(i).getFirst();
                min_heap.offer(new Element(first_element, i, 0));
                cur_max = Math.max(cur_max, first_element);
            }
        }

        // Track the smallest range
        int[] small_range = new int[]{0, Integer.MAX_VALUE};

        while (!min_heap.isEmpty()) {
            final var element = min_heap.poll();

            // Update the smallest range if a better one is found
            if (cur_max - element.value < small_range[1] - small_range[0]) {
                small_range[0] = element.value;
                small_range[1] = cur_max;
            }

            // Move to the next element in the same list
            if (element.elementIndex + 1 < nums.get(element.listIndex).size()) {
                final var next_val = nums.get(element.listIndex).get(element.elementIndex + 1);
                min_heap.offer(new Element(next_val, element.listIndex, element.elementIndex + 1));
                cur_max = Math.max(cur_max, next_val);
            } else {
                // If any list is exhausted, stop
                break;
            }
        }

        return small_range;
    }
}
