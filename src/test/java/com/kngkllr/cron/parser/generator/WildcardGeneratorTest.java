package com.kngkllr.cron.parser.generator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WildcardGeneratorTest {
  @Test
  public void gen() {
    WildcardGenerator g = new WildcardGenerator(2, 4);
    assertEquals(List.of(2, 3, 4), g.generate());
  }
}
