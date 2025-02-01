package com.learn.leetcode.daily.w2024.u202411.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/most-beautiful-item-for-each-query/description/?envType=daily-question&envId=2024-11-12">Task</a>
 * <br><a href="https://leetcode.com/problems/most-beautiful-item-for-each-query/solutions/6035442/beats-100-00-for-loop-explained-with-example/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search, Sorting}
 * </ul>
 * <ul>Hints
 * <li> {@code Can we process the queries in a smart order to avoid repeatedly checking the same items?}
 * <li> {@code How can we use the answer to a query for other queries?}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= items.length, queries.length <= 10^5}
 * <li> {@code items[i].length == 2}
 * <li> {@code 1 <= price[i], beauty[i], queries[j] <= 10^9}
 * </ul>
 * <br>@since 1.0.0
 * <br> 12.11.24 09:02
 */
public final class MostBeautifulItemForEachQuery {

    /**
     *
     * @param items array where {@code items[i] = [price-i, beauty-i]} denotes the price and beauty of an item respectively.
     * @param queries
     * @return an array {@code answer} of the same length as queries where {@code answer[j]} is the answer to the {@code j-th} query.
     */
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int maxI = Integer.MAX_VALUE;
        final List<int[]> res = new ArrayList<>();
        res.add(new int[] {0, 0, maxI});

        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            int[] lastBracket = res.get(res.size() - 1);

            if (beauty > lastBracket[1]) {
                lastBracket[2] = price;
                res.add(new int[] {price, beauty, maxI});
            }
        }

        int[] ans = new int[queries.length];

        for (int j = 0; j < queries.length; j++) {
            int x = queries[j];
            for (int i = res.size() - 1; i >= 0; i--) {
                if (res.get(i)[0] <= x) {
                    ans[j] = res.get(i)[1];
                    break;
                }
            }
        }

        return ans;
    }

    public static int binarySearch(int[][] items, int target) {
        int left = 0;
        int right = items.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (items[mid][0] == target) {
                return mid; // Target found, return the index
            } else if (items[mid][0] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return right; // Target not found, return the index with the price that is less than target
    }
}
