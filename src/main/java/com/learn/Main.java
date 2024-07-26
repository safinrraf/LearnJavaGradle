package com.learn;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import com.learn.leetcode.easy.arrays.RemoveDuplicatesFromSortedArray;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * The entry point.
 *
 * @author radik.safin
 */
@Slf4j
public class Main {

  private static final Map<String, Object> cache = new HashMap<>();

  /**
   * The constructor.
   */
  public Main() {
    log.info("The Main class constructor");
  }

  /**
   * The entry point.
   *
   * @param args input parameters
   */
  public static void main(String[] args) {
    final int[] input = {0, 0, 0, 0, 1, 1, 2, 2, 2};
    final var result = RemoveDuplicatesFromSortedArray.removeDuplicates(input);
    log.info("Array {}", input);
    log.info("Result {}", result);
  }

}