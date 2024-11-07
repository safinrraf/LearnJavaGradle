package com.learn.leetcode.daily.u202411.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/?envType=daily-question&envId=2024-11-07">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Hash Table, Bit Manipulation, Counting}
 * </ul>
 * <ul>Hints
 * <li> {@code For the bitwise AND to be greater than zero, at least one bit should be 1 for every number in the combination.}
 * <li> {@code The candidates are 24 bits long, so for every bit position, we can calculate the size of the largest combination such that the bitwise AND will have a 1 at that bit position.}
 * <li> {@code num & 1} and {@code num >> 1} are drastically faster than {@code num % 2} and {@code num / 2} respectively.
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= candidates.length <= 10^5}
 * <li> {@code 1 <= candidates[i] <= 107}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 07.11.24 08:21
 */
public final class LargestCombinationWithBitwiseAndGreaterThanZero {

    /**
     * {@code Time Complexity O(N * K)}
     * {@code Space Complexity O(N)}
     * @param candidates an array of positive integers.
     * @return the size of the largest combination of {@code candidates} with a bitwise AND greater than {@code 0}.
     */
    public static int largestCombination(int[] candidates) {
        final HashMap<Integer, Integer> bit_set_map = new HashMap<>();
        for(var item : candidates) {
            var shift = 0;
            var tmp = item >> shift;
            while(tmp > 0) {
                if ((tmp & 1) > 0) {
                    //1-th bit is set
                    //save a bit number and sum up the number of occurrences.
                    bit_set_map.merge(shift, 1, Integer::sum);
                }
                tmp = item >> ++shift;
            }
        }

        var max_value = 0;
        for (final var entry : bit_set_map.entrySet()) {
            max_value = Math.max(max_value, entry.getValue());
        }

        return max_value;
    }

    //super fast
    public int largestCombination2(int[] candidates) {
        int[] ans=new int[32];
        for(int x:candidates){
            find(x,ans);
        }
        int res=0;
        for(int i=0;i<32;i++){
            res=Math.max(res,ans[i]);//traverse the bit array and check the max value
        }
        return res;
    }
    public void find(int n,int[] ans){

        int j=31;//index for updating the values in bit array
        while(n>0){
            int a=(n&1);//for checking if bit is set or not
            ans[j]+=a;
            n>>=1;//left shift the given no
            j--;
        }
    }
}
