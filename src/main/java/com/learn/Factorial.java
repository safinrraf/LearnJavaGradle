package com.learn;

import java.math.BigInteger;

public final class Factorial {
  public static BigInteger calcFactorialRecursion(BigInteger n){
    if (n.compareTo(BigInteger.ZERO) < 0) {
      throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
    }
    final var result = BigInteger.ONE;
    if (n.compareTo(BigInteger.ZERO) == 0){
      return result;
    } else {
      return n.multiply(calcFactorialRecursion(n.subtract(BigInteger.ONE)));
    }
  }

  public static BigInteger calcFactorialIteration(Long n) {
    if (n < 0) {
      throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
    }
    var result = BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }
}
