package com.learn.leetcode.daily.x202412.medium;

import java.util.Arrays;
import java.util.Collections;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description/?envType=daily-question&envId=2024-12-06">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Binary Search, Greedy, Sorting}
 * </ul>
 * <ul>Hints
 * <li> {@code Keep the banned numbers that are less than n in a set.}
 * <li> {@code Loop over the numbers from 1 to n and if the number is not banned, use it.}
 * <li> {@code Keep adding numbers while they are not banned, and their sum is less than k.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= banned.length <= 10^4}
 * <li> {@code 1 <= banned[i], n <= 10^4}
 * <li> {@code 1 <= maxSum <= 109}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 06.12.24 16:26
 */
public final class MaximumNumberOfIntegersToChooseFromRange1 {

    /**
     * {@code Time Complexity O(NLogN)}
     * {@code Space Complexity O(N)}
     *
     * @param banned
     * @param n
     * @param maxSum
     * @return the maximum number of integers you can choose following the mentioned rules.
     */
    public static int maxCount(int[] banned, int n, int maxSum) {
        long total_sum = 0L;
        int result = 0;
        Arrays.sort(banned);

        for(int number = 1; number <= n; number++) {
            final int index = Arrays.binarySearch(banned, number);
            if(total_sum + number <= maxSum && index < 0) {
                total_sum += number;
                result++;
            }
        }

        return result;
    }
}
