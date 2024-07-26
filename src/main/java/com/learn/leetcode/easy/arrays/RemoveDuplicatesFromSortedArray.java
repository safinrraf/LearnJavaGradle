package com.learn.leetcode.easy.arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/">Task</a>
 * Example.
 * <p><code>
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * </code>
 */
public final class RemoveDuplicatesFromSortedArray {
  public static int removeDuplicates(int[] nums) {
    int nextPosition = 0;

    for(int i = 1; i < nums.length; i++) {
      if (nums[nextPosition] != nums[i]) {
        nums[++nextPosition] = nums[i];
      }
    }
    return ++nextPosition;
  }

}


//1 1 1 2 3 3 4
//1 2 3 4 - -