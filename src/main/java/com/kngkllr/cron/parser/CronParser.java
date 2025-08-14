package com.kngkllr.cron.parser;

import com.kngkllr.cron.domain.CronSchedule;
import com.kngkllr.cron.exception.CronParseException;

public interface CronParser {
  CronSchedule parse(String expr) throws CronParseException;
}
