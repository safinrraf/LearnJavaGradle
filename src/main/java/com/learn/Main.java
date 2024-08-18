package com.learn;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import com.learn.leetcode.easy.arrays.RemoveDuplicatesFromSortedArray;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import com.learn.leetcode.easy.arrays.RotateArray;
import com.learn.leetcode.easy.arrays.SingleNumber;
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
    final Predicate<String> myIsNull = Objects::isNull;
    final List<String> testList = new ArrayList<>();

    log.info("This is null {}", myIsNull.test(null));
    log.info("This is null {}", myIsNull.test("null"));

    Function<String, String> toLCase = String::toLowerCase;

    log.info("Lower case {}", toLCase.apply("HELLO World!"));
  }
}