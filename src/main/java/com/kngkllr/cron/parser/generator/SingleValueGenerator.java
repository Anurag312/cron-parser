package com.kngkllr.cron.parser.generator;

import java.util.List;

public class SingleValueGenerator implements ValueGenerator {

  private final int value;

  public SingleValueGenerator(int value) {
    this.value = value;
  }

  public List<Integer> generate() {
    return List.of(value);
  }
}
