package com.learn;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

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

    for (int i = 1; i <= 5; i++) {
      //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
      // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
      log.info("i = {}", i);
    }
  }
}