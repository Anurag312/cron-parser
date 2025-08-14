package com.kngkllr.cron.sanitzer;

import com.kngkllr.cron.exception.CronParseException;

public interface InputSanitizer {
  String sanitize(String input) throws CronParseException;
}
