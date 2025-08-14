package com.kngkllr.cron.parser.generator;

import static org.junit.jupiter.api.Assertions.*;

import com.kngkllr.cron.exception.CronParseException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RangeGeneratorTest {
  @Test
  public void gen() throws CronParseException {
    RangeGenerator g = new RangeGenerator(5, 7);
    assertEquals(List.of(5, 6, 7), g.generate());
  }
}
