package com.learn.leetcode.daily.x202412.easy;

import com.learn.leetcode.daily.w2024.x202412.easy.CheckIfNAndItsDoubleExist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfNAndItsDoubleExistTest {

    @Test
    void checkIfExist1() {
        final int[] arr = {10,2,5,3};
        final boolean expected = true;
        final boolean result = CheckIfNAndItsDoubleExist.checkIfExist(arr);

        assertEquals(expected, result);
    }

    @Test
    void checkIfExist2() {
        final int[] arr = {3,1,7,11};
        final boolean expected = false;
        final boolean result = CheckIfNAndItsDoubleExist.checkIfExist(arr);

        assertEquals(expected, result);
    }

    @Test
    void checkIfExist3() {
        final int[] arr = {0,2,-7,11,4,18};
        final boolean expected = true;
        final boolean result = CheckIfNAndItsDoubleExist.checkIfExist(arr);

        assertEquals(expected, result);
    }

    @Test
    void checkIfExist4() {
        final int[] arr = {7,15,3,4,30};
        final boolean expected = true;
        final boolean result = CheckIfNAndItsDoubleExist.checkIfExist(arr);

        assertEquals(expected, result);
    }

    @Test
    void checkIfExist5() {
        final int[] arr = {357,-53,277,-706,980,826,93,-352,-669,989,-193,920,209,-574,-389,221,383,352,665,873,759,
                -480,-64,-103,-721,-623,-642,-680,20,-168,528,-336,-656,264,581,-714,-458,721,815,106,328,476,351,325,
                -954,890,-174,635,95,-443,338,907,-648,113,-278,498,532,-778,95,-487,-909,-642,774,296,417,-132,-951,
                857,-867,321,-960,180,108,-984,-54,103,703,-118,-252,235,577,-703,842,-638,-888,-981,-246,484,202,328,
                661,447,-831,946,-888,-749,-702};
        final boolean expected = true;
        final boolean result = CheckIfNAndItsDoubleExist.checkIfExist(arr);

        assertEquals(expected, result);
    }

    @Test
    void checkIfExist6() {
        final int[] arr = {0,0};
        final boolean expected = true;
        final boolean result = CheckIfNAndItsDoubleExist.checkIfExist(arr);

        assertEquals(expected, result);
    }

    @Test
    void checkIfExist7() {
        final int[] arr = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,
                127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,
                263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,
                419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541,547,557,563,569,571,
                577,587,593,599,601,607,613,617,619,631,641,643,647,653,659,661,673,677,683,691,701,709,719,727,733,
                739,743,751,757,761,769,773,787,797,809,811,821,823,827,829,839,853,857,859,863,877,881,883,887,907,
                911,919,929,937,941,947,953,967,971,977,983,991,997};
        final boolean expected = false;
        final boolean result = CheckIfNAndItsDoubleExist.checkIfExist(arr);

        assertEquals(expected, result);
    }

    @Test
    void checkIfExist8() {
        final int[] arr = {10,2,7,3,0,0,-13};
        final boolean expected = true;
        final boolean result = CheckIfNAndItsDoubleExist.checkIfExist(arr);

        assertEquals(expected, result);
    }

    @Test
    void checkIfExist9() {
        final int[] arr = {-16,-13,8};
        final boolean expected = false;
        final boolean result = CheckIfNAndItsDoubleExist.checkIfExist(arr);

        assertEquals(expected, result);
    }
}