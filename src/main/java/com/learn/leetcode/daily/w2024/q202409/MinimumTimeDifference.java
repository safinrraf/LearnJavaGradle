package com.learn.leetcode.daily.w2024.q202409;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-time-difference/description/?envType=daily-question&envId=2024-09-16">Task</a>
 * <p>1. Sort the timePoints</p>
 * <p>1. Time complexity O(NLogN)</p>
 */
public final class MinimumTimeDifference {
    public static int findMinDifference(List<String> timePoints) {
        final var tmpArr =
                timePoints.stream().map(str ->
                        (Integer.parseInt(str.substring(0, 2)) * 60)
                        + (Integer.parseInt(str.substring(3)))).mapToInt(Integer::intValue).toArray();

        //Sort the array to avoid negative difference
        Arrays.sort(tmpArr);

        var prev = tmpArr[0];
        int minDiffInMinutes = Integer.MAX_VALUE;
        for(int i = 1; i < tmpArr.length; i++) {
            minDiffInMinutes = Math.min(minDiffInMinutes, tmpArr[i] - prev);
            prev = tmpArr[i];
        }

        //additionally compare the first and the last element
        final var minutesDiff = (1440 - tmpArr[tmpArr.length-1]) + tmpArr[0];

        return Math.min(minDiffInMinutes, minutesDiff);
    }
}
