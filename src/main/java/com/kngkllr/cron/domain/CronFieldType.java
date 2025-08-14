package com.kngkllr.cron.domain;

public enum CronFieldType {
  MINUTE(0, 59),
  HOUR(0, 23),
  DOM(1, 31),
  MONTH(1, 12),
  DOW(0, 6);
  public final int min;
  public final int max;

  CronFieldType(int min, int max) {
    this.min = min;
    this.max = max;
  }
}
