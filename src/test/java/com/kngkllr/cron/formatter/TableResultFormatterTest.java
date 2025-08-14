package com.kngkllr.cron.formatter;

import static org.junit.jupiter.api.Assertions.*;

import com.kngkllr.cron.domain.CronSchedule;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TableResultFormatterTest {
  private final TableResultFormatter f = new TableResultFormatter();

  @Test
  public void formatsAllFields() {
    CronSchedule s =
        CronSchedule.builder()
            .minute(List.of(1, 2))
            .hour(List.of(3))
            .dayOfMonth(List.of(4))
            .month(List.of(5))
            .dayOfWeek(List.of(6))
            .command("cmd")
            .build();
    String out = f.format(s);
    String[] lines = out.split("\\r?\\n");
    assertTrue(lines[0].startsWith("minute"));
    assertTrue(lines[1].startsWith("hour"));
    assertTrue(lines[2].startsWith("day of month"));
    assertTrue(lines[3].startsWith("month"));
    assertTrue(lines[4].startsWith("day of week"));
    assertTrue(lines[5].startsWith("command"));
  }
}
