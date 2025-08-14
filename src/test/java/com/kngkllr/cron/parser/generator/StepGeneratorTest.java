package com.kngkllr.cron.parser.generator;

import static org.junit.jupiter.api.Assertions.*;

import com.kngkllr.cron.exception.CronParseException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StepGeneratorTest {
  @Test
  public void gen() throws Exception {
    StepGenerator g = new StepGenerator(new WildcardGenerator(0, 5), 2);
    assertEquals(List.of(0, 2, 4), g.generate());
  }

  @Test
  public void bad() {
    assertThrows(CronParseException.class, () -> new StepGenerator(new WildcardGenerator(0, 1), 0));
  }
}
