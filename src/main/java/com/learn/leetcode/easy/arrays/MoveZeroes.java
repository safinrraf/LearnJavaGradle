package com.learn.leetcode.easy.arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/">Task</a>
 * Accepted.
 */
public final class MoveZeroes {
    /**
     * it is my.*/
    public static void moveZeroes(int[] nums) {
        final var length = nums.length;
        for(int i = 0; i < length; i++) {
            if(nums[i] == 0) {
                for(int j = i + 1; j < length; j++) {
                    if(nums[j] != 0) {
                        nums[i] = nums[i] ^ nums[j];
                        nums[j] = nums[i] ^ nums[j];
                        nums[i] = nums[i] ^ nums[j];
                        break;
                    }
                }
            }
        }
    }

    /**
     * It's not my thing, but it is very cool.*/
    public static void moveZeroes_(int[] nums) {
        int a=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[a]=nums[i];
                a++;
            }
        }
        for(int i = a; i < nums.length; i++){
            nums[i]=0;
        }

    }
}
