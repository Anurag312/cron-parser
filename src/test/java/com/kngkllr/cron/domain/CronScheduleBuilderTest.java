package com.kngkllr.cron.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CronScheduleBuilderTest {
  @Test
  public void buildAllFields() {
    CronSchedule s =
        CronSchedule.builder()
            .minute(List.of(0))
            .hour(List.of(1))
            .dayOfMonth(List.of(2))
            .month(List.of(3))
            .dayOfWeek(List.of(4))
            .command("c")
            .build();
    assertEquals(List.of(0), s.getMinute());
    assertEquals(List.of(1), s.getHour());
    assertEquals(List.of(2), s.getDayOfMonth());
    assertEquals(List.of(3), s.getMonth());
    assertEquals(List.of(4), s.getDayOfWeek());
    assertEquals("c", s.getCommand());
  }
}
