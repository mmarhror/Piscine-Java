
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("'Le 'dd MMM' de l''an' yyyy 'à' HH'h'mm'm et 'ss's'", Locale.FRENCH);

        return dateTime.format(fmt);
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) {
            return null;
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMMM dd yy", Locale.ITALIAN);

        return date.format(fmt);
    }

    public static String formatIso(LocalTime time) {
        if (time == null) {
            return null;
        }
        return time.toString();
    }
}


// Le 27 oct. de l'an 2021 à 16h52m et 31s
// Le 27 octobre de l'an 2021 à 16h52m et 31s