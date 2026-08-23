
import java.util.ArrayList;

public class CleanExtract {

    public static String extract(String s) {
        ArrayList<String> res = new ArrayList<>();

        String[] words = s.split("\\|");

        if (words.length == 1) {
            return s.replace(".", "");
        }

        for (String word : words) {
            int f = word.indexOf('.');
            int l = word.lastIndexOf('.');

            if (f == -1 && !word.trim().isEmpty()) {
                res.add(word.trim());
                continue;
            }

            if (f < l) {
                String extracted = word.substring(f + 1, l).trim();

                if (!extracted.isEmpty()) {
                    res.add(extracted);
                }
            }
        }

        return String.join(" ", res);
    }
}
