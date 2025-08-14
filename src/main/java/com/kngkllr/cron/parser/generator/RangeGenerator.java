package com.kngkllr.cron.parser.generator;

import com.kngkllr.cron.exception.CronParseException;
import java.util.ArrayList;
import java.util.List;

public class RangeGenerator implements ValueGenerator {
  private final int start;
  private final int end;

  public RangeGenerator(int start, int end) throws CronParseException {
    if (start > end) {
      throw new CronParseException("Invalid range: start > end (" + start + " > " + end + ")");
    }
    this.start = start;
    this.end = end;
  }

  public List<Integer> generate() {
    List<Integer> out = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      out.add(i);
    }
    return out;
  }
}
