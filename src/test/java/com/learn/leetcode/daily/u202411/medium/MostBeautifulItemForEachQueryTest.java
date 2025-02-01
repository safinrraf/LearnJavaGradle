package com.learn.leetcode.daily.u202411.medium;

import com.learn.leetcode.daily.w2024.u202411.medium.MostBeautifulItemForEachQuery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <a href="">Task</a>
 * <br><a href="">Explanation</a>
 * <ul>Topics
 * <li> {@code ..., ..., ...}
 * </ul>
 * <ul>Hints
 * <li> {@code ...}
 * </ul>
 * <ul><b>Constraints</b>:
 * <li> {@code 1 ...}
 * </ul>
 * <br>@author radik.safin
 * <br>@since 1.0.0
 * <br> 12.11.24 09:07
 */
class MostBeautifulItemForEachQueryTest {

    @Test
    void binarySearch0() {
        final int[][] items = {{1, 2}, {2, 4}, {3, 2}, {3, 5}, {5, 6}};
        final var expected = 2;
        final var result = MostBeautifulItemForEachQuery.binarySearch(items, 3);

        assertEquals(expected, result);
        System.out.printf(">>>>> [%d, %d]", items[result][0], items[result][1]);
    }

    @Test
    void binarySearch1() {
        final int[][] items = {{1, 2}, {2, 2}, {3, 4}, {5, 6}, {30, 5}};
        final var expected = 3;
        final var result = MostBeautifulItemForEachQuery.binarySearch(items, 7);

        assertEquals(expected, result);
        System.out.printf(">>>>> [%d, %d]", items[result][0], items[result][1]);
    }

    @Test
    void binarySearch2() {
        final int[][] items = {{1, 2}, {2, 2}, {3, 4}, {5, 6}, {30, 5}};
        final var expected = 0;
        final var result = MostBeautifulItemForEachQuery.binarySearch(items, 1);

        assertEquals(expected, result);
        System.out.printf(">>>>> [%d, %d]", items[result][0], items[result][1]);
    }

    @Test
    void binarySearch3() {
        final int[][] items = {{1, 2}, {2, 2}, {3, 4}, {5, 6}, {30, 5}};
        final var expected = 1;
        final var result = MostBeautifulItemForEachQuery.binarySearch(items, 2);

        assertEquals(expected, result);
        System.out.printf(">>>>> [%d, %d]", items[result][0], items[result][1]);
    }

    @Test
    void binarySearch4() {
        final int[][] items = {{1, 2}, {2, 2}, {3, 4}, {5, 6}, {30, 5}};
        final var expected = -1;
        final var result = MostBeautifulItemForEachQuery.binarySearch(items, 0);

        assertEquals(expected, result);
    }

    @Test
    void binarySearch5() {
        final int[][] items = {{10, 2000}};
        final var expected = -1;
        final var result = MostBeautifulItemForEachQuery.binarySearch(items, 5);

        assertEquals(expected, result);
    }

    @Test
    void maximumBeauty1() {
        final int[][] items = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        final int[] queries = {1, 2, 3, 4, 5, 6};
        final int[] expected = {2, 4, 5, 5, 6, 6};
        final int[] result = MostBeautifulItemForEachQuery.maximumBeauty(items, queries);

        assertArrayEquals(expected, result);
    }

    @Test
    void maximumBeauty2() {
        final int[][] items = {{1, 2}, {1, 2}, {1, 3}, {1, 4}};
        final int[] queries = {1};
        final int[] expected = {4};
        final var result = MostBeautifulItemForEachQuery.maximumBeauty(items, queries);

        assertArrayEquals(expected, result);
    }

    @Test
    void maximumBeauty3() {
        final int[][] items = {{10, 1000}};
        final int[] queries = {5};
        final int[] expected = {0};
        final var result = MostBeautifulItemForEachQuery.maximumBeauty(items, queries);

        assertArrayEquals(expected, result);
    }

    @Test
    void maximumBeauty4() {
        final int[][] items = {{193, 732}, {781, 962}, {864, 954}, {749, 627}, {136, 746}, {478, 548}, {640, 908}, {210, 799},
                {567,715},{914,388},{487,853},{533,554},{247,919},{958, 150},{193, 523},{176, 656},
                {395,469},{763,821},{542,946},{701,676}};
        final int[] queries = {885,1445,1580,1309,205,1788,1214,1404,572,1170,989,265,153,151,1479,1180,875,276,1584};
        final int[] expected = {962,962,962,962,746,962,962,962,946,962,962,919,746,746,962,962,962,919,962};
        final var result = MostBeautifulItemForEachQuery.maximumBeauty(items, queries);

        assertArrayEquals(expected, result);
    }
}