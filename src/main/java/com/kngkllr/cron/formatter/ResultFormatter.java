package com.kngkllr.cron.formatter;

import com.kngkllr.cron.domain.CronSchedule;

public interface ResultFormatter {
  String format(CronSchedule schedule);
}
