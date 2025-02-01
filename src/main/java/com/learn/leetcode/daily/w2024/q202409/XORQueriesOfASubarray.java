package com.learn.leetcode.daily.w2024.q202409;

/**
 * <a href="https://leetcode.com/problems/xor-queries-of-a-subarray/description/?envType=daily-question&envId=2024-09-13">Task</a>
 */
public final class XORQueriesOfASubarray {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        final var result = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int tmp=0;
            for(int k = queries[i][0]; k <= queries[i][1]; k++) {
                tmp ^= arr[k];
            }
            result[i] = tmp;
        }

        return result;
    }

    public static int[] xorQueriesNotMy(int[] arr, int[][] queries) {
        int n=arr.length;
        int[] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++) {
            pre[i]=pre[i-1]^arr[i];
        }
        int[] res=new int[queries.length];
        for(int k=0;k<queries.length;k++) {
            int i=queries[k][0];
            int j=queries[k][1];
            if(i==0) {
                res[k]=pre[j];
            } else {
                res[k]=pre[j]^pre[i-1];
            }
        }
        return res;
    }
}
