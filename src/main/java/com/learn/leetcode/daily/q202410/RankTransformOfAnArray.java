package com.learn.leetcode.daily.q202410;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/rank-transform-of-an-array/description/?envType=daily-question&envId=2024-10-02">Task</a>
 */
public final class RankTransformOfAnArray {
    public static int[] arrayRankTransform1(int[] arr) {
        final var tmpArr = new int[arr.length];
        //Use a temporary array to copy the array and sort it.
        System.arraycopy(arr, 0, tmpArr, 0, arr.length);
        Arrays.sort(tmpArr);

        //The rank of each element is the number of
        // unique elements smaller than it in the sorted array plus one.
        for(int i = 0; i < arr.length; i++) {
            int rank = 0;
            int index = 0;
            int prev = tmpArr[index];
            while(tmpArr[index++] != arr[i]) {
                if(prev != tmpArr[index]) {
                    rank++;
                }
                prev = tmpArr[index];
            }
            arr[i] = ++rank;
        }

        return arr;
    }

    public static int[] arrayRankTransform(int[] arr) {
        // Create a copy of the array and sort it
        final var sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Use a HashMap to store the rank of each element
        final HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Assign ranks to each unique element
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // Transform the original array to its ranks
        Arrays.setAll(arr, i -> rankMap.get(arr[i]));

        return arr;
    }
}
