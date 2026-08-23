
import java.util.ArrayList;

public class CleanExtract {

    public static String extract(String s) {
        ArrayList<String> res = new ArrayList<>();

        String[] words = s.split("\\|");

        for (String word : words) {
            int f = word.indexOf('.');
            int l = word.lastIndexOf('.');

            String w = "";

            if (f == -1) {
                w = word.trim();
            } else {
                if (f == 0) {
                    w = word.substring(1).trim();
                } else if (l == word.length() - 1) {
                    w = word.substring(0, l).trim();
                }
            }

            if (!w.trim().isEmpty()) {
                res.add(w.trim());
            }
        }

        return String.join(" ", res);
    }
}
