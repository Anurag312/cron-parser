package com.kngkllr.cron.parser.tokenizer;

import com.kngkllr.cron.exception.CronParseException;

public class WhitespaceTokenizer implements CronExpressionTokenizer {
  public String[] tokenize(String expr) throws CronParseException {
    String[] parts = expr.trim().split("\\s+", 6);
    if (parts.length != 6) {
      throw new CronParseException("Expected 5 fields and command");
    }
    return parts;
  }
}
