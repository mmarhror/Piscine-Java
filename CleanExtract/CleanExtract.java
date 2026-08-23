
import java.util.ArrayList;

public class CleanExtract {

    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        ArrayList<String> res = new ArrayList<>();
        String[] segments = s.split("\\|");

        for (String segment : segments) {
            int firstDot = segment.indexOf('.');
            int lastDot = segment.lastIndexOf('.');

            String extracted = "";

            if (firstDot == -1) {
                // No dots at all in this segment
                extracted = segment.trim();
            } else if (firstDot < lastDot) {
                // At least two dots: extract between first and last dot
                extracted = segment.substring(firstDot + 1, lastDot).trim();
            }

            // Only add if there is actual content (avoids extra spaces)
            if (!extracted.isEmpty()) {
                res.add(extracted);
            }
        }

        return String.join(" ", res);
    }
}
