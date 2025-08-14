package com.kngkllr.cron.io;

public class ConsoleOutputWriter implements OutputWriter {
  public void write(String output) {
    System.out.print(output);
  }
}
