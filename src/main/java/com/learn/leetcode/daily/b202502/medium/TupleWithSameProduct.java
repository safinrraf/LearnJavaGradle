package com.learn.leetcode.daily.b202502.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/tuple-with-same-product/description/?envType=daily-question&envId=2025-02-06">Task</a>
 * <br><a href="https://leetcode.com/problems/tuple-with-same-product/editorial/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Counting}
 * </ul>
 * <ul>Hints
 * <li> {@code Note that all of the integers are distinct. This means that each time a product is formed it must be formed by two unique integers.}
 * <li> {@code Count the frequency of each product of 2 distinct numbers. Then calculate the permutations formed.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 1000}
 * <li> {@code 1 <= nums[i] <= 10^4}
 * <li> {@code All elements in nums are distinct.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 06.02.25 08:14
 */
public final class TupleWithSameProduct {

    /**
     * Approach 2: Count Product Frequency
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param nums an array of distinct positive integers
     * @return the number of tuples {@code (a, b, c, d)} such that {@code a * b = c * d} where {@code a}, {@code b}, {@code c}, and {@code d} are elements of {@code nums}, and {@code a != b != c != d}.
     */
    public static int tupleSameProduct(int[] nums) {
        int numsLength = nums.length;
        final List<Integer> pairProducts = new ArrayList<>();
        int totalNumberOfTuples = 0;

        // Iterate over nums to calculate all pairwise products
        for (int firstIndex = 0; firstIndex < numsLength; firstIndex++) {
            for (
                    int secondIndex = firstIndex + 1;
                    secondIndex < numsLength;
                    secondIndex++
            ) {
                pairProducts.add(nums[firstIndex] * nums[secondIndex]);
            }
        }

        Collections.sort(pairProducts);

        int lastProductSeen = -1;
        int sameProductCount = 0;

        // Iterate over pairProducts to count how many times each product occurs
        for (
                int productIndex = 0;
                productIndex < pairProducts.size();
                productIndex++
        ) {
            if (pairProducts.get(productIndex) == lastProductSeen) {
                // Increment the count of same products
                sameProductCount++;
            } else {
                // Calculate how many pairs had the previous product value
                int pairsOfEqualProduct =
                        ((sameProductCount - 1) * sameProductCount) / 2;

                totalNumberOfTuples += 8 * pairsOfEqualProduct;

                // Update lastProductSeen and reset sameProductCount
                lastProductSeen = pairProducts.get(productIndex);
                sameProductCount = 1;
            }
        }

        // Handle the last group of products (since the loop ends without adding
        // it)
        int pairsOfEqualProduct =
                ((sameProductCount - 1) * sameProductCount) / 2;
        totalNumberOfTuples += 8 * pairsOfEqualProduct;

        return totalNumberOfTuples;
    }
}
