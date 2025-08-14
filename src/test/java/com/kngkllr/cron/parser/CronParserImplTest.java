package com.kngkllr.cron.parser;

import static org.junit.jupiter.api.Assertions.*;

import com.kngkllr.cron.domain.CronSchedule;
import com.kngkllr.cron.exception.CronParseException;
import org.junit.jupiter.api.Test;

public class CronParserImplTest {
  private final CronParserImpl p = new CronParserImpl();

  @Test
  public void valid() throws CronParseException {
    CronSchedule s = p.parse("*/15 0 1,15 * 1-5 x");
    assertEquals(
        "0 15 30 45", String.join(" ", s.getMinute().stream().map(Object::toString).toList()));
  }

  @Test
  public void tooFew() {
    assertThrows(CronParseException.class, () -> p.parse("* * *"));
  }

  @Test
  public void outOfRange() {
    assertThrows(CronParseException.class, () -> p.parse("60 * * * * c"));
  }

  @Test
  public void invalidNumber() {
    assertThrows(CronParseException.class, () -> p.parse("x * * * * cmd"));
  }

  @Test
  public void invalidStepZero() {
    assertThrows(CronParseException.class, () -> p.parse("*/0 * * * * cmd"));
  }

  @Test
  public void invalidRange() {
    assertThrows(CronParseException.class, () -> p.parse("5-3 * * * * cmd"));
  }
}
