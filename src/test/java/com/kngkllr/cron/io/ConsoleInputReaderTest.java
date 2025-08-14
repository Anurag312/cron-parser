package com.kngkllr.cron.io;

import static org.junit.jupiter.api.Assertions.*;

import com.kngkllr.cron.exception.CronParseException;
import org.junit.jupiter.api.Test;

public class ConsoleInputReaderTest {
  @Test
  public void valid() throws Exception {
    InputReader r = new ConsoleInputReader();
    assertEquals("x", r.read(new String[] {"x"}));
  }

  @Test
  public void invalid() {
    InputReader r = new ConsoleInputReader();
    assertThrows(CronParseException.class, () -> r.read(new String[] {}));
  }
}
