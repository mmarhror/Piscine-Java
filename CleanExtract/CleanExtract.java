
import java.util.ArrayList;

public class CleanExtract {

    public static String extract(String s) {
        if (s == null) {
            return null;
        }

        ArrayList<String> res = new ArrayList<>();
        String[] words = s.split("\\|");

        for (String word : words) {
            int f = word.indexOf('.');
            int l = word.lastIndexOf('.');

            String extracted = "";

            if (f == -1) {
                // No dots: keep the word as is
                extracted = word.trim();
            } else if (f < l) {
                // Two or more dots: extract between the first and last dot
                extracted = word.substring(f + 1, l).trim();
            } else {
                // Exactly one dot (f == l)
                if (f == 0) {
                    // Dot is at the beginning -> take everything after
                    extracted = word.substring(1).trim();
                } else if (l == word.length() - 1) {
                    // Dot is at the end -> take everything before
                    extracted = word.substring(0, l).trim();
                } else {
                    // Dot in the middle
                    extracted = word.substring(f + 1).trim();
                }
            }

            if (!extracted.isEmpty()) {
                res.add(extracted);
            }
        }

        return String.join(" ", res);
    }
}
