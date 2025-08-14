package com.kngkllr.cron.io;

import org.junit.jupiter.api.Test;

public class ConsoleOutputWriterTest {
  @Test
  public void write() {
    OutputWriter w = new ConsoleOutputWriter();
    w.write("ok");
  }
}
