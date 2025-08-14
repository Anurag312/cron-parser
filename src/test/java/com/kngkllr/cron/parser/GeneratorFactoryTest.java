package com.kngkllr.cron.parser;

import static org.junit.jupiter.api.Assertions.*;

import com.kngkllr.cron.domain.CronFieldType;
import com.kngkllr.cron.exception.CronParseException;
import com.kngkllr.cron.parser.generator.ValueGenerator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GeneratorFactoryTest {

  @Test
  public void wildcardAllMinutes() throws CronParseException {
    ValueGenerator g = GeneratorFactory.create("*", CronFieldType.MINUTE);
    List<Integer> vals = g.generate();
    assertEquals(60, vals.size());
    assertEquals(0, vals.get(0));
    assertEquals(59, vals.get(59));
  }

  @Test
  public void singleValue() throws CronParseException {
    ValueGenerator g = GeneratorFactory.create("7", CronFieldType.HOUR);
    List<Integer> vals = g.generate();
    assertEquals(List.of(7), vals);
  }

  @Test
  public void simpleRange() throws CronParseException {
    ValueGenerator g = GeneratorFactory.create("2-4", CronFieldType.DOM);
    assertEquals(List.of(2, 3, 4), g.generate());
  }

  @Test
  public void stepOnly() throws CronParseException {
    ValueGenerator g = GeneratorFactory.create("*/20", CronFieldType.MINUTE);
    assertEquals(List.of(0, 20, 40), g.generate());
  }

  @Test
  public void rangeWithStep() throws CronParseException {
    ValueGenerator g = GeneratorFactory.create("10-16/3", CronFieldType.MINUTE);
    assertEquals(List.of(10, 13, 16), g.generate());
  }

  @Test
  public void commaSeparatedParts() throws CronParseException {
    ValueGenerator g = GeneratorFactory.create("5,10-12/2,56-58", CronFieldType.MINUTE);
    List<Integer> vals = g.generate();
    assertEquals(List.of(5, 10, 12, 56, 57, 58), vals);
  }

  @Test
  public void invalidNumberThrows() {
    assertThrows(
        CronParseException.class, () -> GeneratorFactory.create("x", CronFieldType.MINUTE));
  }

  @Test
  public void invalidRangeBoundsThrows() {
    assertThrows(
        CronParseException.class, () -> GeneratorFactory.create("100-200", CronFieldType.MINUTE));
  }

  @Test
  public void invalidStepThrows() {
    assertThrows(
        CronParseException.class, () -> GeneratorFactory.create("*/0", CronFieldType.MINUTE));
  }
}
