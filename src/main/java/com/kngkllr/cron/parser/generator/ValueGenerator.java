package com.kngkllr.cron.parser.generator;

import com.kngkllr.cron.exception.CronParseException;
import java.util.List;

public interface ValueGenerator {
  List<Integer> generate() throws CronParseException;
}
