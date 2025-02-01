package com.learn.leetcode.daily.w2024.q202409;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/largest-number/description/?envType=daily-question&envId=2024-09-18">Task</a>
 * <a href="https://leetcode.com/problems/largest-number/solutions/5785445/best-solution-simplified-easy-approach-java-c-python/?envType=daily-question&envId=2024-09-18">Explanation</a>
 */
public final class LargestNumber {
    public String largestNumber(int[] nums) {
        final var array =  new String[nums.length];
        for(int i=0; i<nums.length; i++){
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (a, b)-> (b+a).compareTo(a+b));
        if(array[0].equals("0")){
            return "0";
        }
        final var largest = new StringBuilder();
        for (String s : array) {
            largest.append(s);
        }
        return largest.toString();
    }
}
