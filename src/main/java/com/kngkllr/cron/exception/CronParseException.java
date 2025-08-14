package com.kngkllr.cron.exception;

public class CronParseException extends Exception {
  public CronParseException(String message) {
    super(message);
  }

  public CronParseException(String message, Throwable cause) {
    super(message, cause);
  }
}
