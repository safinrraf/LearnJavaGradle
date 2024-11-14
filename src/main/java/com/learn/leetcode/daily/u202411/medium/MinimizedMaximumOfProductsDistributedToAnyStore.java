package com.learn.leetcode.daily.u202411.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/?envType=daily-question&envId=2024-11-14">Task</a>
 * <br><a href="https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/solutions/6043066/easy-simple-approach-minimized-maximum-of-products-distributed-to-any-store-beats-100/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Binary Search}
 * </ul>
 * <ul>Hints
 * <li> {@code There exists a monotonic nature such that when x is smaller than some number, there will be no way to distribute, and when x is not smaller than that number, there will always be a way to distribute.}
 * <li> {@code If you are given a number k, where the number of products given to any store does not exceed k, could you determine if all products can be distributed?}
 * <li> {@code Implement a function canDistribute(k), which returns true if you can distribute all products such that any store will not be given more than k products, and returns false if you cannot. Use this function to binary search for the smallest possible k.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code m == quantities.length}
 * <li> {@code 1 <= m <= n <= 10^5}
 * <li> {@code 1 <= quantities[i] <= 10^5}
 * </ul>
 * <br>@since 1.0.0
 * <br> 14.11.24 10:11
 */
public final class MinimizedMaximumOfProductsDistributedToAnyStore {

    /**
     *
     * @param n
     * @param quantities
     * @return the minimum possible {@code x}.
     */
    public static int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (solve(n, quantities, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean solve(int n, int[] quantities, int item) {
        if (item == 0) return false;
        int store = 0;
        for (int product : quantities) {
            store += (product - 1) / item + 1;
            if (store > n) return false;
        }
        return true;
    }
}
