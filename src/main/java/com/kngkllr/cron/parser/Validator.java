package com.kngkllr.cron.parser;

import com.kngkllr.cron.exception.CronParseException;

public class Validator {
  public static void validateRange(int value, int min, int max) throws CronParseException {
    if (value < min || value > max) {
      throw new CronParseException("Value out of range " + value);
    }
  }
}
