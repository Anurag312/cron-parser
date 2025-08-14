package com.kngkllr.cron.parser.generator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class SingleValueGeneratorTest {
  @Test
  public void gen() {
    SingleValueGenerator g = new SingleValueGenerator(9);
    assertEquals(List.of(9), g.generate());
  }
}
