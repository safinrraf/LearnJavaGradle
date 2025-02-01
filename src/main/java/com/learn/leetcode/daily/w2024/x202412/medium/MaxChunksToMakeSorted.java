package com.learn.leetcode.daily.w2024.x202412.medium;

/**
 * <a href="https://leetcode.com/problems/max-chunks-to-make-sorted/description/?envType=daily-question&envId=2024-12-19">Task</a>
 * <br><a href="https://leetcode.com/problems/max-chunks-to-make-sorted/solutions/6144279/max-chunks-to-make-sorted/?envType=daily-question&envId=2024-12-19">Explanation</a>
 * <ul>Topics
 * <li> {@code Árray, Stack, Greedy, Sorting, Monotonic Stack}
 * </ul>
 * <ul>Hints
 * <li> {@code The first chunk can be found as the smallest k for which A[:k+1] == [0, 1, 2, ...k]; then we repeat this process.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code n == arr.length}
 * <li> {@code 1 <= n <= 10}
 * <li> {@code 0 <= arr[i] < n}
 * <li> {@code All the elements of arr are unique.}
 * </ul>
 * <br>@since 1.0.0
 * <br> 19.12.24 08:14
 */
public final class MaxChunksToMakeSorted {

    /**
     *
     * <p>
     * {@code Time Complexity O(N)}<br>
     * {@code Space Complexity O(1)}
     * </p>
     * @param arr an integer array.
     * @return the largest number of chunks we can make to sort the array.
     */
    public static int maxChunksToSorted(int[] arr) {
        int result = 0;
        int c = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            c += i;
            sum += arr[i];
            if(sum == c) {
                result++;
            }
        }

        return result;
    }
}
