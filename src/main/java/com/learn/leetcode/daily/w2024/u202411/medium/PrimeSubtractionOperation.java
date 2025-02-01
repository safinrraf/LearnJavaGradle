package com.learn.leetcode.daily.w2024.u202411.medium;

import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/prime-subtraction-operation/description/?envType=daily-question&envId=2024-11-11">Task</a>
 * <br><a href="https://leetcode.com/problems/prime-subtraction-operation/solutions/6031906/beats-100-video-best-explaining-greedy-sieve-of-eratosthenes-atkin-working-11-11-2024/">Explanation</a>
 * <ul>Topics
 * <li> {@code Array, Math, Binary Search, Greedy, Number Theory}
 * </ul>
 * <ul>Hints
 * <li> {@code Think about if we have many primes to subtract from nums[i]. Which prime is more optimal?}
 * <li> {@code The most optimal prime to subtract from nums[i] is the one that makes nums[i] the smallest as possible and greater than nums[i-1].}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 <= nums.length <= 1000}
 * <li> {@code 1 <= nums[i] <= 1000}
 * <li> {@code nums.length == n}
 * </ul>
 * <br>@since 1.0.0
 * <br> 11.11.24 08:29
 */
public final class PrimeSubtractionOperation {

    /**
     * {@code Time Complexity O(...)}
     * {@code Space Complexity O(...)}
     * @param nums
     * @return
     * well... almost, did not pass the 588 / 654 testcases passed
     * 15,20,17,7,16
     */
    public static boolean primeSubOperationAlmost(int[] nums) {
        final var primes = List.of(
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
                127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
                193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263,
                269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347,
                349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421,
                431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
                503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593,
                599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661,
                673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757,
                761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853,
                857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
                947, 953, 967, 971, 977, 983, 991, 997);

        for(int i = nums.length - 1; i > 0 ; i--) {
            if(nums[i - 1] >= nums[i]) {
                if(nums[i - 1] <= 2 && (i - 1) > 1 ) {
                    //sorry, no chance
                    //if I see 1 or 2, and it is not the first, then I can not make it strictly increasing
                    return false;
                }

                //get the nearest prime number
                var nearest_prime_position = Collections.binarySearch(primes, nums[i - 1]);
                if(nearest_prime_position > 0) {
                    //repeat, because we found the prime itself
                    nearest_prime_position = Collections.binarySearch(primes, nums[i - 1] - 1);
                }
                nearest_prime_position *= -1;
                while(nearest_prime_position >= 2 && nums[i - 1] - primes.get(nearest_prime_position-2) >= nums[i]) {
                    nearest_prime_position--;
                }

                if(nearest_prime_position < 2) {
                    return false;
                }

                nums[i - 1] -= primes.get(nearest_prime_position-2);
            }
        }

        return true;
    }

    public static boolean primeSubOperation(int[] nums) {
        final var primes = new int[]{
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
                53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
                127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
                193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263,
                269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347,
                349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421,
                431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499,
                503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593,
                599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661,
                673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757,
                761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853,
                857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
                947, 953, 967, 971, 977, 983, 991, 997};

        int prev = 0;
        for (int num : nums) {
            if (num <= prev) {
                return false;
            }
            int i = bisectLeft(primes, num - prev) - 1;
            if (i != -1) {
                num -= primes[i];
            }
            prev = num;
        }
        return true;
    }

    /**
     * Binary search
     * @param arr
     * @param target
     * @return
     */
    private static int bisectLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
