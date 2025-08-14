package com.kngkllr.cron.parser;

import com.kngkllr.cron.domain.CronFieldType;
import com.kngkllr.cron.domain.CronSchedule;
import com.kngkllr.cron.exception.CronParseException;
import com.kngkllr.cron.parser.tokenizer.CronExpressionTokenizer;
import com.kngkllr.cron.parser.tokenizer.WhitespaceTokenizer;
import java.util.List;

public class CronParserImpl implements CronParser {

  private final CronExpressionTokenizer tokenizer = new WhitespaceTokenizer();

  public CronSchedule parse(String expr) throws CronParseException {
    String[] t = tokenizer.tokenize(expr);
    int idx = 0;
    List<Integer> minute = GeneratorFactory.create(t[idx++], CronFieldType.MINUTE).generate();
    List<Integer> hour = GeneratorFactory.create(t[idx++], CronFieldType.HOUR).generate();
    List<Integer> dom = GeneratorFactory.create(t[idx++], CronFieldType.DOM).generate();
    List<Integer> month = GeneratorFactory.create(t[idx++], CronFieldType.MONTH).generate();
    List<Integer> dow = GeneratorFactory.create(t[idx++], CronFieldType.DOW).generate();
    return CronSchedule.builder()
        .minute(minute)
        .hour(hour)
        .dayOfMonth(dom)
        .month(month)
        .dayOfWeek(dow)
        .command(t[5])
        .build();
  }
}
