package com.learn.leetcode.daily.x202412.easy;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/?envType=daily-question&envId=2024-12-18">Task</a>
 * <br><a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/solutions/6154427/final-prices-with-a-special-discount-in-a-shop/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Stack, Monotonic Stack}
 * </ul>
 * <ul>Hints
 * <li> {@code Use brute force: For the ith item in the shop with a loop find the first position j satisfying the conditions and apply the discount, otherwise, the discount is 0.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= prices.length <= 500}
 * <li> {@code 1 <= prices[i] <= 1000}
 * </ul>
 * <br>@since 1.0.0
 * <br> 18.12.24 08:16
 */
public final class FinalPricesWithSpecialDiscountInShop {

    /**
     * Approach 1: Brute-Force
     * <p>
     * {@code Time Complexity O(N^2)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param prices an integer array {@code prices} where {@code prices[i]} is the price of the {@code i-th} item in a shop.
     * @return an integer array {@code answer} where {@code answer[i]} is the final price you will pay for the {@code i-th} item of the shop, considering the special discount.
     */
    public static int[] finalPrices(int[] prices) {
        final int n = prices.length;
        // Create a copy of original prices array to store discounted prices
        int[] result = prices.clone();

        for (int i = 0; i < n; i++) {
            // Look for first smaller or equal price that comes after current item
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    // Apply discount by subtracting prices[j] from current price
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Approach 2: Monotonic Stack
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param prices an integer array {@code prices} where {@code prices[i]} is the price of the {@code i-th} item in a shop.
     * @return an integer array {@code answer} where {@code answer[i]} is the final price you will pay for the {@code i-th} item of the shop, considering the special discount.
     */
    public static int[] finalPrices2(int[] prices) {
        // Create a copy of prices array to store discounted prices
        final int[] result = prices.clone();

        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            // Process items that can be discounted by current price
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                // Apply discount to previous item using current price
                result[stack.pop()] -= prices[i];
            }
            // Add current index to stack
            stack.add(i);
        }

        return result;
    }
}
