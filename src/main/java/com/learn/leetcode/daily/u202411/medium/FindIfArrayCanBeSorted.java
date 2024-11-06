package com.learn.leetcode.daily.u202411.medium;

/**
 * <a href="https://leetcode.com/problems/find-if-array-can-be-sorted/?envType=daily-question&envId=2024-11-06">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Bit Manipulation, Sorting}
 * </ul>
 * <ul>Hints
 * <li> {@code Split the array into segments. Each segment contains consecutive elements with the same number of set bits.}
 * <li> {@code From left to right, the previous segment’s largest element should be smaller than the current segment’s smallest element.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 100}
 * <li> {@code 1 <= nums[i] <= 2^8}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 06.11.24 08:17
 */
public final class FindIfArrayCanBeSorted {

    /**
     *
     * @param nums
     * @return {@code true} if you can sort the array, else return {@code false}.
     */
    public static boolean canSortArray(int[] nums) {
        //Bubble sort
        for (int i = 0; i < nums.length - 1; i++) {
            var swapped = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    if(Integer.bitCount(nums[j]) != Integer.bitCount(nums[j + 1])) {
                        return false;
                    }
                    // Swap nums[j] and nums[j+1]
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                    swapped = true;
                }
            }

            // If no two elements were swapped in inner loop, then break
            if (!swapped) {
                break;
            }
        }

        return true;
    }
}
