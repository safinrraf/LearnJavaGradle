package com.learn.leetcode.common;

/**
 * The time complexity of the Prefix Sum Array is O(N).
 * The space complexity of the Prefix Sum Array is O(N).
 */
public final class PrefixSumArray {
    public static int[] constructPrefixSumArray(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }
    public static void main(String[] args) {
        int[] inputArray = {3, 1, 5, 2, 4};
        int[] prefixSumArray = constructPrefixSumArray(inputArray);
        for (int num : prefixSumArray) {
            System.out.print(num + " ");
        }
    }
}
