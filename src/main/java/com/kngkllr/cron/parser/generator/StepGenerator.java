package com.kngkllr.cron.parser.generator;

import com.kngkllr.cron.exception.CronParseException;
import java.util.ArrayList;
import java.util.List;

public class StepGenerator implements ValueGenerator {
  private final List<Integer> baseList;
  private final int step;
  private final int offset;

  public StepGenerator(ValueGenerator base, int step) throws CronParseException {
    if (step <= 0) {
      throw new CronParseException("Step must be >0");
    }
    this.baseList = base.generate();
    if (baseList.isEmpty()) {
      throw new CronParseException("No base values");
    }
    this.step = step;
    this.offset = baseList.get(0);
  }

  public List<Integer> generate() {
    List<Integer> out = new ArrayList<>();
    for (int v : baseList) {
      if ((v - offset) % step == 0) {
        out.add(v);
      }
    }
    return out;
  }
}
