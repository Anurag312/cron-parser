package com.kngkllr.cron.parser.tokenizer;

import static org.junit.jupiter.api.Assertions.*;

import com.kngkllr.cron.exception.CronParseException;
import org.junit.jupiter.api.Test;

public class WhitespaceTokenizerTest {
  private final WhitespaceTokenizer t = new WhitespaceTokenizer();

  @Test
  public void valid() throws Exception {
    String[] p = t.tokenize("a b c d e f");
    assertEquals(6, p.length);
  }

  @Test
  public void invalid() {
    assertThrows(CronParseException.class, () -> t.tokenize("a b c"));
  }
}
