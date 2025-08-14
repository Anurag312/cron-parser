package com.kngkllr.cron.sanitzer;

import com.kngkllr.cron.exception.CronParseException;

public class BasicInputSanitizer implements InputSanitizer {

  public String sanitize(String input) throws CronParseException {
    if (input == null || input.isBlank()) {
      throw new CronParseException("Input is empty");
    }
    String t = input.trim();
    if (t.startsWith("\"") && t.endsWith("\"") && t.length() > 1) {
      return t.substring(1, t.length() - 1).trim();
    }
    return t;
  }
}
