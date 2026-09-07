import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ParseDate {

  public static LocalDateTime parseIsoFormat(String stringDate) {
    return LocalDateTime.parse(stringDate);
  }

  public static LocalDate parseFullTextFormat(String stringDate) {
    DateTimeFormatter fmt =
        new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("EEEE dd MMMM yyyy")
            .toFormatter();

    return LocalDate.parse(stringDate, fmt);
  }

  public static LocalTime parseTimeFormat(String stringDate) {
    stringDate =
        stringDate
            .replace(" hours in the evening, ", ":")
            .replace(" minutes and ", ":")
            .replace(" seconds", "");

    return LocalTime.parse(stringDate);
  }
}
