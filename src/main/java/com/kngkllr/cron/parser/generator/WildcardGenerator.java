package com.kngkllr.cron.parser.generator;

import java.util.ArrayList;
import java.util.List;

public class WildcardGenerator implements ValueGenerator {
  private final int min;
  private final int max;

  public WildcardGenerator(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public List<Integer> generate() {
    List<Integer> out = new ArrayList<>();
    for (int i = min; i <= max; i++) {
      out.add(i);
    }
    return out;
  }
}
