package com.kngkllr.cron.parser;

import com.kngkllr.cron.domain.CronFieldType;
import com.kngkllr.cron.exception.CronParseException;
import com.kngkllr.cron.parser.generator.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GeneratorFactory {
  private static final Pattern RANGE = Pattern.compile("(-?\\d+)-(-?\\d+)");

  public static ValueGenerator create(String spec, CronFieldType type) throws CronParseException {

    String[] parts = spec.split(",");
    List<Integer> all = new ArrayList<>();

    for (String raw : parts) {
      String p = raw.trim();
      if (p.isEmpty()) {
        throw new CronParseException("Empty field segment");
      }

      String[] sp = p.split("/", 2);
      String token = sp[0];
      int step = sp.length == 2 ? parseStep(sp[1]) : 1;

      ValueGenerator base = makeBaseGenerator(token, type);
      ValueGenerator gen = (step == 1) ? base : new StepGenerator(base, step);
      all.addAll(gen.generate());
    }

    return () -> all.stream().distinct().sorted().toList();
  }

  private static ValueGenerator makeBaseGenerator(String token, CronFieldType type)
      throws CronParseException {

    if (token.equals("*")) {
      return new WildcardGenerator(type.min, type.max);
    }

    if (RANGE.matcher(token).matches()) {
      String[] b = token.split("-", 2);
      int s = parseInt(b[0]);
      int e = parseInt(b[1]);
      Validator.validateRange(s, type.min, type.max);
      Validator.validateRange(e, type.min, type.max);
      return new RangeGenerator(s, e);
    }

    int v = parseInt(token);
    Validator.validateRange(v, type.min, type.max);
    return new SingleValueGenerator(v);
  }

  private static int parseInt(String s) throws CronParseException {
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException ex) {
      throw new CronParseException("Invalid number: " + s, ex);
    }
  }

  private static int parseStep(String s) throws CronParseException {
    int step = parseInt(s);
    if (step <= 0) {
      throw new CronParseException("Step must be >0: " + s);
    }
    return step;
  }
}
