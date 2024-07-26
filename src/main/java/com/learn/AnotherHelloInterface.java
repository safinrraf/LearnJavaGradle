package com.learn;

import java.time.LocalDateTime;

@FunctionalInterface
public interface AnotherHelloInterface {
  String sayHello(String name, LocalDateTime localDateTime);
}
