package com.kngkllr.cron.io;

import com.kngkllr.cron.exception.CronParseException;

public interface InputReader {
  String read(String[] args) throws CronParseException;
}
