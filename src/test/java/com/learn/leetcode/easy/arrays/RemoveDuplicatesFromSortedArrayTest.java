package com.learn.leetcode.easy.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveDuplicatesFromSortedArrayTest {

  @Test
  void removeDuplicates1() {
    final int[] input = {1, 2};
    final int[] expected = {1, 2};
    final var numberOfUniqueElements = RemoveDuplicatesFromSortedArray.removeDuplicates(input);

    assertEquals(2, numberOfUniqueElements);
    assertArrayEquals(expected, input);
  }

  @Test
  void removeDuplicates2() {
    final int[] input = {1};
    final int[] expected = {1};
    final var numberOfUniqueElements = RemoveDuplicatesFromSortedArray.removeDuplicates(input);

    assertEquals(1, numberOfUniqueElements);
    assertArrayEquals(expected, input);
  }

  @Test
  void removeDuplicates3() {
    final int[] input = {1, 1, 1};
    final int[] expected = {1, 1, 1};
    final var numberOfUniqueElements = RemoveDuplicatesFromSortedArray.removeDuplicates(input);

    assertEquals(1, numberOfUniqueElements);
    assertArrayEquals(expected, input);
  }
}