package com.learn.leetcode.easy.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/">Task</a>
 */
@Slf4j
public final class IntersectionOfTwoArrays2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        var smallArr = new int[]{};
        var bigArr = new int[]{};

        if (nums1.length <= nums2.length) {
            smallArr = nums1;
            bigArr = nums2;
        } else {
            smallArr = nums2;
            bigArr = nums1;
        }
        final var result = new ArrayList<Integer>();
        Arrays.sort(smallArr);
        Arrays.sort(bigArr);

        int index = 0;
        for (int i=0; i < smallArr.length; i++) {
            for (int j=index; j < bigArr.length; j++) {
                if (smallArr[i] == bigArr[j]) {
                    result.add(smallArr[i]);
                    index = j + 1;
                    break;
                }
            }
        }

        final var resultArr = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            resultArr[k] = result.get(k);
        }
        return resultArr;
    }
}
