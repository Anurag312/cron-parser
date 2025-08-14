package com.kngkllr.cron.sanitzer;

import static org.junit.jupiter.api.Assertions.*;

import com.kngkllr.cron.exception.CronParseException;
import org.junit.jupiter.api.Test;

public class BasicInputSanitizerTest {
  private final BasicInputSanitizer s = new BasicInputSanitizer();

  @Test
  public void trimQuotes() throws Exception {
    assertEquals("a b", s.sanitize("\" a b \""));
  }

  @Test
  public void blank() {
    assertThrows(CronParseException.class, () -> s.sanitize(" "));
  }

  @Test
  public void nullInput() {
    assertThrows(CronParseException.class, () -> s.sanitize(null));
  }
}
