package com.kngkllr.cron.app;

import com.kngkllr.cron.exception.CronParseException;
import com.kngkllr.cron.formatter.ResultFormatter;
import com.kngkllr.cron.formatter.TableResultFormatter;
import com.kngkllr.cron.io.ConsoleInputReader;
import com.kngkllr.cron.io.ConsoleOutputWriter;
import com.kngkllr.cron.io.InputReader;
import com.kngkllr.cron.io.OutputWriter;
import com.kngkllr.cron.parser.CronParser;
import com.kngkllr.cron.parser.CronParserImpl;
import com.kngkllr.cron.sanitzer.BasicInputSanitizer;
import com.kngkllr.cron.sanitzer.InputSanitizer;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Builder
public class CronApplication {
  private final InputReader reader;
  private final InputSanitizer sanitizer;
  private final CronParser parser;
  private final ResultFormatter formatter;
  private final OutputWriter writer;

  public void run(String[] args) {
    try {
      String raw = reader.read(args);
      String clean = sanitizer.sanitize(raw);
      var schedule = parser.parse(clean);
      String out = formatter.format(schedule);
      writer.write(out);
    } catch (CronParseException e) {
      log.error(e.getMessage());
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    CronApplication app =
        CronApplication.builder()
            .reader(new ConsoleInputReader())
            .sanitizer(new BasicInputSanitizer())
            .parser(new CronParserImpl())
            .formatter(new TableResultFormatter())
            .writer(new ConsoleOutputWriter())
            .build();
    app.run(args);
  }
}
