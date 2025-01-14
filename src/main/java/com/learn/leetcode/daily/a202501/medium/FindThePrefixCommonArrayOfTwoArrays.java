package com.learn.leetcode.daily.a202501.medium;

/**
 * <a href="https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/?envType=daily-question&envId=2025-01-14">Task</a>
 * <br><a href="https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/editorial/?envType=daily-question&envId=2025-01-14">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Bit Manipulation}
 * </ul>
 * <ul>Hints
 * <li> {@code Consider keeping a frequency array that stores the count of occurrences of each number till index i.}
 * <li> {@code If a number occurred two times, it means it occurred in both A and B since they’re both permutations so add one to the answer.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= A.length == B.length == n <= 50}
 * <li> {@code 1 <= A[i], B[i] <= n}
 * <li> {@code It is guaranteed that A and B are both a permutation of n integers.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 14.01.25 10:12
 */
public final class FindThePrefixCommonArrayOfTwoArrays {

    /**
     * Approach 3: Single Pass with Frequency Array
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param A 0-indexed integer array.
     * @param B 0-indexed integer array.
     * @return the <b>prefix common array</b> of {@code A} and {@code B}.
     */
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        final int N = A.length;
        final int[] prefixCommonArray = new int[N];
        final int[] frequency = new int[N + 1];
        int commonCount = 0;

        // Iterate through the elements of both arrays
        for (int currentIndex = 0; currentIndex < N; ++currentIndex) {
            // Increment frequency of current elements in A and B
            // Check if the element in A has appeared before (common in prefix)
            frequency[A[currentIndex]] += 1;
            if (frequency[A[currentIndex]] == 2) {
                ++commonCount;
            }

            // Check if the element in B has appeared before (common in prefix)
            frequency[B[currentIndex]] += 1;
            if (frequency[B[currentIndex]] == 2) {
                ++commonCount;
            }

            // Store the count of common elements for the current prefix
            prefixCommonArray[currentIndex] = commonCount;
        }

        // Return the final array with counts of common elements in each prefix
        return prefixCommonArray;
    }
}
