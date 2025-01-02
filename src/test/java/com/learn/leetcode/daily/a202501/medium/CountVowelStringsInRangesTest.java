package com.learn.leetcode.daily.a202501.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CountVowelStringsInRangesTest {

    @Test
    void vowelStrings1() {
        final String[] words = {"aba","bcb","ece","aa","e"};
        final int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        final int[] expected = {2,3,0};
        final int[] result = CountVowelStringsInRanges.vowelStrings(words, queries);

        assertArrayEquals(expected, result);
    }

    @Test
    void vowelStrings2() {
        final String[] words = {"a","e","i"};
        final int[][] queries = {{0, 2}, {0, 1}, {2, 2}};
        final int[] expected = {3,2,1};
        final int[] result = CountVowelStringsInRanges.vowelStrings(words, queries);

        assertArrayEquals(expected, result);
    }

    @Test
    void vowelStrings3() {
        final String[] words = {"b","c","f"};
        final int[][] queries = {{0, 2}, {0, 1}, {2, 2}};
        final int[] expected = {0,0,0};
        final int[] result = CountVowelStringsInRanges.vowelStrings(words, queries);

        assertArrayEquals(expected, result);
    }

    @Test
    void vowelStrings4() {
        final String[] words = {"b","rmivyakd","kddwnexxssssnvrske","vceguisunlxtldqenxiyfupvnsxdubcnaucpoi",
                "nzwdiataxfkbikbtsjvcbjxtr","wlelgybcaakrxiutsmwnkuyanvcjczenuyaiy","eueryyiayq",
                "bghegfwmwdoayakuzavnaucpur","ukorsxjfkdojcxgjxgmxbghno","pmgbiuzcwbsakwkyspeikpzhnyiqtqtfyephqhl",
                "gsjdpelkbsruooeffnvjwtsidzw","ugeqzndjtogxjkmhkkczdpqzwcu","ppngtecadjsirj","rvfeoxunxaqezkrlr",
                "adkxoxycpinlmcvmq","gfjhpxlzmokcmvhjcrbrpfakspscmju","rgmzhaj","ychktzwdhfuruhpvdjwfsqjhztshcxdey",
                "yifrzmmyzvfk","mircixfzzobcficujgbj","d","pxcmwnqknyfkmafzbyajjildngccadudfziknos",
                "dxmlikjoivggmyasaktllgmfhqpyznc","yqdbiiqexkemebyuitve"};
        final int[][] queries = {{5, 21}, {17, 22}, {19, 23}, {13, 15}, {20, 23}, {21, 23}, {6, 20}, {1, 8}, {15, 20},
                {17, 22}, {6, 6}, {1, 2}, {4, 11}, {14, 23}, {7, 10}, {16, 22}, {20, 22}, {21, 22}, {15, 18}, {5, 16}, {17, 23}};
        final int[] expected = {2,0,0,0,0,0,2,1,0,0,0,0,2,0,1,0,0,0,0,2,0};
        final int[] result = CountVowelStringsInRanges.vowelStrings(words, queries);

        assertArrayEquals(expected, result);
    }
}