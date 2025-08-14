package com.kngkllr.cron.formatter;

import com.kngkllr.cron.domain.CronSchedule;
import java.util.List;
import java.util.StringJoiner;

public class TableResultFormatter implements ResultFormatter {
  public String format(CronSchedule s) {
    StringBuilder sb = new StringBuilder();
    line(sb, "minute", s.getMinute());
    line(sb, "hour", s.getHour());
    line(sb, "day of month", s.getDayOfMonth());
    line(sb, "month", s.getMonth());
    line(sb, "day of week", s.getDayOfWeek());
    sb.append(String.format("%-14s%s%n", "command", s.getCommand()));
    return sb.toString();
  }

  private void line(StringBuilder sb, String name, List<Integer> vals) {
    StringJoiner j = new StringJoiner(" ");
    vals.forEach(v -> j.add(v.toString()));
    sb.append(String.format("%-14s%s%n", name, j.toString()));
  }
}
