package com.kngkllr.cron.io;

import com.kngkllr.cron.exception.CronParseException;

public class ConsoleInputReader implements InputReader {
  public String read(String[] args) throws CronParseException {
    if (args == null || args.length != 1) {
      throw new CronParseException("Expected exactly one argument");
    }
    return args[0];
  }
}
