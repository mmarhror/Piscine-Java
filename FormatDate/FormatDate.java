
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("'Le 'dd MMMM' de l''an' yyyy 'à' hh'h'mm'm et 'ss's'", Locale.FRENCH);

        return dateTime.format(fmt);
    }

    public static String formatSimple(LocalDate date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM dd yy", Locale.ITALIAN);

        return date.format(fmt);
    }

    public static String formatIso(LocalTime time) {
        return time.toString();
    }
}
