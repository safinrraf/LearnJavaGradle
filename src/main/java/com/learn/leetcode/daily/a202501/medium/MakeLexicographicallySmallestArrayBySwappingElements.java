package com.learn.leetcode.daily.a202501.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/?envType=daily-question&envId=2025-01-25">Task</a>
 * <br><a href="https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/editorial/?envType=daily-question&envId=2025-01-25">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Union Find, Sorting}
 * </ul>
 * <ul>Hints
 * <li> {@code Construct a virtual graph where all elements in nums are nodes and the pairs satisfying the condition have an edge between them.}
 * <li> {@code Instead of constructing all edges, we only care about the connected components.}
 * <li> {@code Can we use DSU?}
 * <li> {@code Sort nums. Now we just need to consider if the consecutive elements have an edge to check if they belong to the same connected component. Hence, all connected components become a list of position-consecutive elements after sorting.}
 * <li> {@code For each index of nums from 0 to nums.length - 1 we can change it to the current minimum value we have in its connected component and remove that value from the connected component.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 10^5}
 * <li> {@code 1 <= nums[i] <= 10^9}
 * <li> {@code 1 <= limit <= 10^9}
 * </ul>
 * <br>@since 1.0.0
 * <br> 25.01.25 19:37
 */
public final class MakeLexicographicallySmallestArrayBySwappingElements {

    /**
     * Approach: Sorting + Grouping
     * <p>
     * {@code Time Complexity O(N * LogN)}<br>
     * {@code Space Complexity O(N)}
     * </p>
     * @param nums
     * @param limit
     * @return the <b>lexicographically smallest array</b> that can be obtained by performing the operation any number of times.
     */
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        final int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);

        int currGroup = 0;
        final HashMap<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);

        final HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(
                currGroup,
                new LinkedList<>(List.of(numsSorted[0]))
        );

        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(numsSorted[i] - numsSorted[i - 1]) > limit) {
                // new group
                currGroup++;
            }

            // assign current element to group
            numToGroup.put(numsSorted[i], currGroup);

            // add element to sorted group list
            if (!groupToList.containsKey(currGroup)) {
                groupToList.put(currGroup, new LinkedList<>());
            }
            groupToList.get(currGroup).add(numsSorted[i]);
        }

        // iterate through input and overwrite each element with the next element in its corresponding group
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            final int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }

        return nums;
    }
}
