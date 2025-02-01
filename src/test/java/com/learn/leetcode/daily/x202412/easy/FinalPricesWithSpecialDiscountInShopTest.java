package com.learn.leetcode.daily.x202412.easy;

import com.learn.leetcode.daily.w2024.x202412.easy.FinalPricesWithSpecialDiscountInShop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinalPricesWithSpecialDiscountInShopTest {

    @Test
    void finalPrices1() {
        final int[] prices = {8,4,6,2,3};
        final int[] expected = {4,2,4,2,3};
        final int[] result = FinalPricesWithSpecialDiscountInShop.finalPrices(prices);

        assertArrayEquals(expected, result);
    }

    @Test
    void finalPrices2() {
        final int[] prices = {1,2,3,4,5};
        final int[] expected = {1,2,3,4,5};
        final int[] result = FinalPricesWithSpecialDiscountInShop.finalPrices(prices);

        assertArrayEquals(expected, result);
    }

    @Test
    void finalPrices3() {
        final int[] prices = {10,1,1,6};
        final int[] expected = {9,0,1,6};
        final int[] result = FinalPricesWithSpecialDiscountInShop.finalPrices(prices);

        assertArrayEquals(expected, result);
    }

    @Test
    void finalPrices4() {
        final int[] prices = {8,4,6,2,3};
        final int[] expected = {4,2,4,2,3};
        final int[] result = FinalPricesWithSpecialDiscountInShop.finalPrices2(prices);

        assertArrayEquals(expected, result);
    }

    @Test
    void finalPrices5() {
        final int[] prices = {1,2,3,4,5};
        final int[] expected = {1,2,3,4,5};
        final int[] result = FinalPricesWithSpecialDiscountInShop.finalPrices2(prices);

        assertArrayEquals(expected, result);
    }

    @Test
    void finalPrices6() {
        final int[] prices = {10,1,1,6};
        final int[] expected = {9,0,1,6};
        final int[] result = FinalPricesWithSpecialDiscountInShop.finalPrices2(prices);

        assertArrayEquals(expected, result);
    }
}