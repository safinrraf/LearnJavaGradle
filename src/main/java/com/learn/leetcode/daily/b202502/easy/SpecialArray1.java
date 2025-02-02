package com.learn.leetcode.daily.b202502.easy;

/**
 * <a href="https://leetcode.com/problems/special-array-i/description/?envType=daily-question&envId=2025-02-01">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code Array}
 * </ul>
 * <ul>Hints
 * <li> {@code Try to check the parity of each element and its previous element.}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 100}
 * <li> {@code 1 <= nums[i] <= 100}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 01.02.25 19:20
 */
public final class SpecialArray1 {

    /**
     *
     * <p>
     * {@code Time Complexity O(...)}<br>
     * {@code Space Complexity O(...)}
     * </p>
     * @param nums
     * @return {@code true} if nums is a <b>special</b> array, otherwise, return {@code false}.
     */
    public static boolean isArraySpecial(int[] nums) {
        final int N = nums.length;

        for(int i = 1; i < N; i++) {
            if ((nums[i - 1] % 2) == (nums[i] % 2)) {
                return false;
            }
        }
        return true;
    }
}
