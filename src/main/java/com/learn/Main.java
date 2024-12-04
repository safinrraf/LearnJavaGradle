package com.learn;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import com.learn.leetcode.daily.q202408.TwoKeysKeyboard;
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
    final var powerOfTwo = new PowerOfTwo();

    log.info("> {}", powerOfTwo.next());
    log.info("> {}", powerOfTwo.next());
    log.info("> {}", powerOfTwo.next());
    log.info("> {}", powerOfTwo.next());
    log.info("> {}", powerOfTwo.next());
    log.info("> {}", powerOfTwo.next());
    log.info("> {}", powerOfTwo.next());
    log.info("> {}", powerOfTwo.next());
    log.info("> {}", powerOfTwo.next());
    log.info("> {}", powerOfTwo.next());
  }
}