package com.learn;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.math.BigInteger;
import lombok.extern.slf4j.Slf4j;

/**
 * The entry point.
 *
 * @author radik.safin
 */
@Slf4j
public class Main {

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
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

    log.info("Hello and welcome!");

    final var startR = System.nanoTime();
    log.info("Factorial R {}", Factorial.calcFactorialRecursion(BigInteger.valueOf(30L)));
    final var stopR = System.nanoTime();

    final var startI = System.nanoTime();
    log.info("Factorial I {}", Factorial.calcFactorialIteration(30L));
    final var stopI = System.nanoTime();

    log.info("R time in nano seconds: {}", stopR-startR);
    log.info("I time in nano seconds: {}", stopI-startI);

    for (int i = 1; i <= 5; i++) {
      //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
      // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
      log.info("i = {}", i);
    }
  }
}