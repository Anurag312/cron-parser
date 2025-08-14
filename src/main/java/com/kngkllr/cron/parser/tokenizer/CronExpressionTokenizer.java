package com.kngkllr.cron.parser.tokenizer;

import com.kngkllr.cron.exception.CronParseException;

public interface CronExpressionTokenizer {
  String[] tokenize(String expression) throws CronParseException;
}
