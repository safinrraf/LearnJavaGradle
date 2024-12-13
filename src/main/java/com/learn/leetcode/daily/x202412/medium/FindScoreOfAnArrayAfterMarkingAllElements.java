package com.learn.leetcode.daily.x202412.medium;

/**
 * <a href="https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/?envType=daily-question&envId=2024-12-13">Task</a>
 * <br><a href="https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/solutions/6142041/15-approaches-explained-incredibly-long-solution/">Explanation</a>
 * <ul>Topics
 * <li> {@code Heap (Priority Queue), Sorting, Array, Simulation, Hash Table, Ordered Set, Ordered Map, Greedy, Monotonic Stack, Sliding Window, Two Pointers, Stack, Divide and Conquer, Radix Sort}
 * <li> {@code Queue, Dynamic Programming, Doubly-Linked List, Data Stream, Bit Manipulation, Hash Function, Design, Tree, String, Iterator, Counting Sort}
 * </ul>
 * <ul>Hints
 * <li> {@code Try simulating the process of marking the elements and their adjacent.}
 * <li> {@code If there is an element that was already marked, then you skip it.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 10^5}
 * <li> {@code 1 <= nums[i] <= 10^6}
 * </ul>
 * <br>@since 1.0.0
 * <br> 13.12.24 08:13
 */
public final class FindScoreOfAnArrayAfterMarkingAllElements {

    /**
     * <p>
     * <ul>Starting with {@code score = 0}, apply the following algorithm:
     * <li> Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
     * <li> Add the value of the chosen integer to {@code score}.
     * <li> Mark <b>the chosen element and its two adjacent elements if they exist</b>.
     * <li> Repeat until all the array elements are marked.
     * </ul>
     * </p>
     * <br>
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param nums an array consisting of positive integers.
     * @return the score you get after applying the above algorithm.
     */
    public static long findScore(int[] nums) {
        final int n = nums.length;
        long sum = 0;
        int l = 0, r = 0;
        while (r < n) {
            l = r;
            while (r + 1 < n && nums[r] > nums[r + 1]) {
                r++;
            }
            for (int i = r; i >= l; i -= 2) {
                sum += nums[i];
            }
            r += 2;
        }
        return sum;
    }
}
