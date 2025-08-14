package com.kngkllr.cron.parser;

import static org.junit.jupiter.api.Assertions.*;

import com.kngkllr.cron.exception.CronParseException;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
  @Test
  public void valid() throws Exception {
    Validator.validateRange(2, 0, 5);
  }

  @Test
  public void invalid() {
    assertThrows(CronParseException.class, () -> Validator.validateRange(6, 0, 5));
  }
}
