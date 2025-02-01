package com.learn.leetcode.daily.w2024.x202412.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/check-if-n-and-its-double-exist/description/?envType=daily-question&envId=2024-12-01">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Two Pointers, Binary Search, Sorting}
 * </ul>
 * <ul>Hints
 * <li> {@code Loop from i = 0 to arr.length, maintaining in a hashTable the array elements from [0, i - 1].}
 * <li> {@code On each step of the loop check if we have seen the element 2 * arr[i] so far.}
 * <li> {@code Also check if we have seen arr[i] / 2 in case arr[i] % 2 == 0.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 2 <= arr.length <= 500}
 * <li> {@code -10^3 <= arr[i] <= 10^3}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 01.12.24 14:03
 */
public final class CheckIfNAndItsDoubleExist {

    /**
     * <p>Given an array {@code arr} of integers, check if there exist two indices {@code i} and {@code j} such that :</p>
     * <li> {@code i != j}
     * <li> {@code 0 <= i, j < arr.length}
     * <li> {@code arr[i] == 2 * arr[j]}
     *
     * {@code Time Complexity O(N)}
     * {@code Space Complexity O(N)}
     *
     * @param arr
     * @return {@code true} if exists, {@code false} otherwise.
     */
    public static boolean checkIfExist(int[] arr) {
        final Set<Integer> set = new HashSet<>();

        for(final var item : arr) {
            if(set.contains(2 * item) || (item % 2 == 0 && set.contains(item / 2))) {
                return true;
            }
            set.add(item);
        }

        return false;
    }
}
