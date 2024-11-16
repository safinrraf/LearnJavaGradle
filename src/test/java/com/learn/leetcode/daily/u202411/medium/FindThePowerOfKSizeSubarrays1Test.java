package com.learn.leetcode.daily.u202411.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindThePowerOfKSizeSubarrays1Test {

    @Test
    void resultsArray1() {
        final int[] nums = {1,2,3,4,3,2,5};
        final int k = 3;
        final int[] expected = {3,4,-1,-1,-1};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void resultsArray2() {
        final int[] nums = {2,2,2,2,2};
        final int k = 4;
        final int[] expected = {-1,-1};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void resultsArray3() {
        final int[] nums = {3,2,3,2,3,2};
        final int k = 2;
        final int[] expected = {-1,3,-1,3,-1};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void resultsArray4() {
        final int[] nums = {1};
        final int k = 1;
        final int[] expected = {1};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void resultsArray5() {
        final int[] nums = {1,2};
        final int k = 2;
        final int[] expected = {2};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void resultsArray6() {
        final int[] nums = {1,1,1,2};
        final int k = 2;
        final int[] expected = {-1,-1,2};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void resultsArray7() {
        final int[] nums = {20,28,29,30};
        final int k = 3;
        final int[] expected = {-1,30};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void resultsArray8() {
        final int[] nums = {1,4};
        final int k = 1;
        final int[] expected = {1,4};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void resultsArray9() {
        final int[] nums = {1,3,4};
        final int k = 2;
        final int[] expected = {-1,4};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }

    @Test
    void resultsArray10() {
        final int[] nums = {99079,28223,1753,1754,1755,1756,1757,1758,1759,1760,1761,1762,1763,1764,1765,1766,1767,
                1768,1769,4639,4640,4641,4642,4643,4644,4645,4646,4647,4648,4649,4650,4651,4652,4653,4654,4655,4656,
                4657,4658,4659,4660,4661,4662,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,
                29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,
                62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,441,442,443,444,445,446,447,
                448,449,450,451,452,453,454,455,456,457,458,459,1950,1807,1808,1809,1810,1811,1812,1813,1814,1815,1816,
                1817,1818,1819,1820,1821,1822,1823,1824,1825,1826,1827,1828,1829,1830,1831,1832,1833,1834,1835,1836,
                1837,1838,1839,1840,1841,1842,1843,1844,1845,1846,1847,1848,1849,1850,1851,1852,1853,1854,1855,1856,
                1857,1858,1859,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,
                392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,
                417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,
                442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,
                467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,491,
                492,493,494,495,496,497,498,499,500,501,502,503,504,505,506,507,508,509,510,511,512,513,514,515,516,
                517,518,519,520,521,522,523,524,525,526,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,
                542,543,544,545,546,547,548,549,550,551,552,553,554,555,556,557,558,559,560,561,562,563,564,565,566,
                567,568,569,570,571,572,573,574,575,576,577,578,579,580,581,582,583,584,585,586,587,588,589,590,591,
                592,593,594,595,596,597,598,599,600,601,602,603,604,605,606,607,608,609,610,611,612,613,614,615,616,
                617,618,619,620,621,622,623,624,625,626,627,628,629,630,631,632,633,634,635,636,637,638,639,640,641,
                642,643,644,645,646,647,648,649,650,651,3264,3265,3266,3267,3268,3269,3270,3271,3272,3273,3274,3275,
                3276,3277,3278,3279,3795,3796,3797,2461,2462};
        final int k = 281;
        final int[] expected = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 651, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        final int[] result = FindThePowerOfKSizeSubarrays1.resultsArray(nums, k);

        assertArrayEquals(expected, result);
    }
}