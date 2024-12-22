package com.learn.leetcode.daily.x202412.hard;


import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 * <a href="https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/description/?envType=daily-question&envId=2024-12-22">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search, Stack, Binary Indexed Tree, Segment Tree, Heap (Priority Queue), Monotonic Stack}
 * </ul>
 * <ul>Hints
 * <li> {@code For each query [x, y], if x > y, swap x and y. Now, we can assume that x <= y.}
 * <li> {@code For each query [x, y], if x == y or heights[x] < heights[y], then the answer is y since x ≤ y.}
 * <li> {@code Otherwise, we need to find the smallest index t such that y < t and heights[x] < heights[t]. Note that heights[y] <= heights[x], so heights[x] < heights[t] is a sufficient condition.}
 * <li> {@code To find index t for each query, sort the queries in descending order of y. Iterate over the queries while maintaining a monotonic stack which we can binary search over to find index t.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= heights.length <= 5 * 10^4}
 * <li> {@code 1 <= heights[i] <= 10^9}
 * <li> {@code 1 <= queries.length <= 5 * 10^4}
 * <li> {@code queries[i] = [a-i, b-i]}
 * <li> {@code 0 <= a-i, b-i <= heights.length - 1}
 * </ul>
 * <br>@since 1.0.0
 * <br> 22.12.24 13:01
 */
public final class FindBuildingWhereAliceAndBobCanMeet {

    /**
     * Approach 1: Monotonic Stack
     * <p>
     * {@code Time Complexity O(Q * LogN)}<br>
     * {@code Space Complexity O(N + Q)}
     * </p>
     * @param heights a 0-indexed array of positive integers, where {@code heights[i]} represents the height of the {@code i-th} building.
     * @param queries array where {@code queries[i] = [a-i, b-i]}. On the ith query, Alice is in building {@code a-i} while Bob is in building {@code b-i}.
     * @return an array {@code ans} where {@code ans[i]} is <b>the index of the leftmost building</b> where Alice and Bob can meet on the {@code i-th} query. If Alice and Bob cannot move to a common building on query {@code i}, set {@code ans[i]} to {@code -1}.
     */
    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<Pair<Integer, Integer>> monoStack = new ArrayList<>();
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        List<List<Pair<Integer, Integer>>> newQueries = new ArrayList<>(
                heights.length
        );

        for (int i = 0; i < heights.length; i++) {
            newQueries.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (heights[b] > heights[a] || a == b) {
                result[i] = b;
            } else {
                // TODO: fix
                // newQueries.get(b).add(new Pair<>(heights[a], i));
            }
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            int monoStackSize = monoStack.size();
            for (Pair<Integer, Integer> pair : newQueries.get(i)) {
                int position = search(pair.getKey(), monoStack);
                if (position < monoStackSize && position >= 0) {
                    result[pair.getValue()] = monoStack
                            .get(position)
                            .getValue();
                }
            }

            while (
                    !monoStack.isEmpty() &&
                            monoStack.get(monoStack.size() - 1).getKey() <= heights[i]
            ) {
                monoStack.remove(monoStack.size() - 1);
            }

            //TODO: fix it
            // monoStack.add(new Pair<>(heights[i], i));
        }

        return result;
    }

    private static int search(int height, List<Pair<Integer, Integer>> monoStack) {
        int left = 0;
        int right = monoStack.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (monoStack.get(mid).getKey() > height) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * Approach 2: Priority Queue
     * <p>
     * {@code Time Complexity O(Q * LogQ)}<br>
     * {@code Space Complexity O(N + Q)}
     * </p>
     * @param heights a 0-indexed array of positive integers, where {@code heights[i]} represents the height of the {@code i-th} building.
     * @param queries array where {@code queries[i] = [a-i, b-i]}. On the ith query, Alice is in building {@code a-i} while Bob is in building {@code b-i}.
     * @return an array {@code ans} where {@code ans[i]} is <b>the index of the leftmost building</b> where Alice and Bob can meet on the {@code i-th} query. If Alice and Bob cannot move to a common building on query {@code i}, set {@code ans[i]} to {@code -1}.
     */
    public static int[] leftmostBuildingQueries_PQ(int[] heights, int[][] queries) {
        final List<List<List<Integer>>> storeQueries = new ArrayList<>(
                heights.length
        );
        for (int i = 0; i < heights.length; i++) storeQueries.add(
                new ArrayList<>()
        );
        final PriorityQueue<List<Integer>> maxIndex = new PriorityQueue<>(
                (a, b) -> a.get(0) - b.get(0)
        );
        final int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        //Store the mappings for all queries in storeQueries.
        for (int currQuery = 0; currQuery < queries.length; currQuery++) {
            final int a = queries[currQuery][0];
            final int b = queries[currQuery][1];
            if (a < b && heights[a] < heights[b]) {
                result[currQuery] = b;
            } else if (a > b && heights[a] > heights[b]) {
                result[currQuery] = a;
            } else if (a == b) {
                result[currQuery] = a;
            } else {
                storeQueries
                        .get(Math.max(a, b))
                        .add(
                                Arrays.asList(
                                        Math.max(heights[a], heights[b]),
                                        currQuery
                                )
                        );
            }
        }

        //If the priority queue's minimum pair value is less than the current index of height, it is an answer to the query.
        for (int index = 0; index < heights.length; index++) {
            while (
                    !maxIndex.isEmpty() && maxIndex.peek().get(0) < heights[index]
            ) {
                result[maxIndex.peek().get(1)] = index;
                maxIndex.poll();
            }
            // Push the with their maximum index as the current index in the priority queue.
            for (List<Integer> element : storeQueries.get(index)) {
                maxIndex.offer(element);
            }
        }
        return result;
    }
}
