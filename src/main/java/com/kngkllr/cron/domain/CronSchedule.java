package com.kngkllr.cron.domain;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CronSchedule {
  private final List<Integer> minute;
  private final List<Integer> hour;
  private final List<Integer> dayOfMonth;
  private final List<Integer> month;
  private final List<Integer> dayOfWeek;
  private final String command;
}
